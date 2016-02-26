package genkalium

import util.allJavaFXClasses
import util.dekeyword
import util.getPropertyValueType
import util.projectRoot
import java.io.FileWriter
import java.lang.reflect.Modifier
import java.nio.file.Paths

fun main(args: Array<String>) {
    val kaliumPath = Paths.get(projectRoot, "kotlinfx-core", "src", "main", "kotlin", "kotlinfx", "kalium", "Generated.kt")!!
    val fw = FileWriter(kaliumPath.toFile())
    fw.append("package kotlinfx.kalium\n\n")
//    fw.append("import kotlinfx.kalium.template\n")
    fw.append("import javafx.beans.value.ObservableValue\n\n")

    for (clazz in allJavaFXClasses()) {
        if (clazz.canonicalName == null) continue;
        if (!Modifier.isPublic(clazz.modifiers)) continue

        val className = clazz.canonicalName!!
        var classNamePrinted = false

        for (method in clazz.declaredMethods) {
            val name = method.name!!

            if (!name.endsWith("Property")) continue
            if (name.contains("impl_")) continue // For public types that should be treated as private
            if (!Modifier.isPublic(method.modifiers)) continue
            // TODO JavaFX properties that take a parameter are not supported yet
            if (method.parameterCount > 0) continue
            // TODO Static properties are not supported yet
            if (Modifier.isStatic(method.modifiers)) continue

            val shortName = dekeyword(name.substring(0..name.length -9))

            // See http://docs.oracle.com/javafx/2/api/javafx/beans/property/package-summary.html
            val ty = method.genericReturnType!!.typeName!!
            val valTy: String? = getPropertyValueType(ty)
            if (valTy == null) {
                println("ERROR: $ty")
                continue
            }

            val valTyKt = kotlinfyType(valTy)
            val tyParamArray = clazz.typeParameters
            val tyParams = util.genTypeParamsString(tyParamArray)
            val tyParamsFirst = util.genFirstTypeParamsString(tyParamArray)
            val template =
"""
@Suppress("USELESS_CAST_STATIC_ASSERT_IS_FINE", "UNCHECKED_CAST")
public fun $tyParamsFirst $className$tyParams.$shortName(f: (() -> $valTyKt)? = null): $valTyKt =
    template("$shortName", f, this, $name()!! as ObservableValue<$valTyKt>)
"""
            if (!classNamePrinted) {
                fw.append("\n// "+className+"\n")
                classNamePrinted = true
            }
            fw.append(template)
            println(className); println("  "+valTyKt)
        }
    }

    fw.close()
}

fun kotlinfyType(ty: String): String {
    var t = util.kotlinfyType(ty)
    // The following are special cases where I could not think of a general solution
    t = t.replace("TableView.ResizeFeatures", "TableView.ResizeFeatures<S>")
    if (t == "javafx.scene.control.TablePosition") t = "javafx.scene.control.TablePosition<*,*>"
    if (t == "javafx.scene.control.TableRow") t = "javafx.scene.control.TableRow<*>"
    return t
}

