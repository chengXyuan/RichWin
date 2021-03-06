package de.carey.richwin.util.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    //Getter函数 如果已经被初始化，则会返回一个值，否则会抛异常。
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("this object not initialized")
    }

    //Setter函数 如果仍然是null，则赋值，否则会抛异常。
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("object already initialized")
    }

    object DelegatesExt {
        fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
    }
}