package kotlinfx.abbreviations

import javafx.beans.value.*
import javafx.beans.property.*
import javafx.collections.*

// These are extension properties that had to be provided by hand
// as the generation script could not handle them correctly.

@Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
public val javafx.print.JobSettings.pageRangesp: javafx.beans.property.ObjectProperty<*>
    get() = pageRangesProperty()!!

@Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
public val <S> javafx.scene.control.TableView.TableViewFocusModel<S>.focusedCellp: javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TablePosition<*, *>>
    get() = focusedCellProperty()!!

@Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
public val <S> javafx.scene.control.TreeTableView<S>.columnResizePolicyp: javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TreeTableView.ResizeFeatures<*>, Boolean>>
    get() = columnResizePolicyProperty()!!

@Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
public val <S> javafx.scene.control.TableView<S>.columnResizePolicyp: javafx.beans.property.ObjectProperty<javafx.util.Callback<javafx.scene.control.TableView.ResizeFeatures<*>, Boolean>>
    get() = columnResizePolicyProperty()!!

@Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
public val <S, T> javafx.scene.control.TableCell<S, T>.tableRowp: javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.control.TableRow<*>>
    get() = tableRowProperty()!!


// These are extension properties that are so few that it would
// not be worth it too generate them automatically.

// http://docs.oracle.com/javafx/2/api/javafx/beans/value/package-summary.html

public val ObservableBooleanValue.v: Boolean
    get() = value!!

public val ObservableDoubleValue.v: Double
    get() = get()

public val ObservableFloatValue.v: Float
    get() = get()

public val ObservableLongValue.v: Long
    get() = get()

public val ObservableIntegerValue.v: Int
    get() = get()

public val ObservableStringValue.v: String
    get() = value!!

public val <T> ObservableValue<T>.v: T
    get() = value!!

public val <T> ObservableObjectValue<T>.v: T
    get() = value!!

public val <E> ObservableListValue<E>.v: ObservableList<E>
    get() = value!!

public val <E> ObservableSetValue<E>.v: ObservableSet<E>
    get() = value!!

public val <K, V> ObservableMapValue<K, V>.v: ObservableMap<K, V>
    get() = value!!


public var WritableBooleanValue.v: Boolean
    get() = value!!
    set(v) {
        value = v
    }

public var WritableDoubleValue.v: Double
    get() = get()
    set(v) = set(v)

public var WritableFloatValue.v: Float
    get() = get()
    set(v) = set(v)

public var WritableLongValue.v: Long
    get() = get()
    set(v) = set(v)

public var WritableIntegerValue.v: Int
    get() = get()
    set(v) = set(v)

public var WritableStringValue.v: String
    get() = value!!
    set(v) {
        value = v
    }

public var <T> WritableValue<T>.v: T
    get() = value!!
    set(v) = setValue(v)

public var <T> WritableObjectValue<T>.v: T
    get() = value!!
    set(v) = setValue(v)

public var <E> WritableListValue<E>.v: ObservableList<E>
    get() = value!!
    set(v) = setValue(v)

public var <E> WritableSetValue<E>.v: ObservableSet<E>
    get() = value!!
    set(v) = setValue(v)

public var <K, V> WritableMapValue<K, V>.v: ObservableMap<K, V>
    get() = value!!
    set(v) = setValue(v)


// http://docs.oracle.com/javafx/2/api/javafx/beans/property/package-summary.html

public var BooleanProperty.v: Boolean
    get() = value!!
    set(v) {
        value = v
    }

public var DoubleProperty.v: Double
    get() = value!!
    set(v) {
        value = v
    }

public var FloatProperty.v: Float
    get() = value!!
    set(v) {
        value = v
    }

public var LongProperty.v: Long
    get() = value!!
    set(v) {
        value = v
    }

public var IntegerProperty.v: Int
    get() = value!!
    set(v) {
        value = v
    }

public var StringProperty.v: String
    get() = value!!
    set(v) {
        value = v
    }

public var <T> ObjectProperty<T>.v: T
    get() = value!!
    set(v) = setValue(v)

public var <E> ListProperty<E>.v: ObservableList<E>
    get() = value!!
    set(v) = setValue(v)

public var <E> SetProperty<E>.v: ObservableSet<E>
    get() = value!!
    set(v) = setValue(v)

public var <K, V> MapProperty<K, V>.v: ObservableMap<K, V>
    get() = value!!
    set(v) = setValue(v)

public val ReadOnlyBooleanProperty.v: Boolean
    get() = value!!

public val ReadOnlyDoubleProperty.v: Double
    get() = value!!

public val ReadOnlyFloatProperty.v: Float
    get() = value!!

public val ReadOnlyLongProperty.v: Long
    get() = value!!

public val ReadOnlyIntegerProperty.v: Int
    get() = value!!

public val ReadOnlyStringProperty.v: String
    get() = value!!

public val <T> ReadOnlyObjectProperty<T>.v: T
    get() = value!!

public val <E> ReadOnlyListProperty<E>.v: ObservableList<E>
    get() = value!!

public val <E> ReadOnlySetProperty<E>.v: ObservableSet<E>
    get() = value!!

public val <K, V> ReadOnlyMapProperty<K, V>.v: ObservableMap<K, V>
    get() = value!!
