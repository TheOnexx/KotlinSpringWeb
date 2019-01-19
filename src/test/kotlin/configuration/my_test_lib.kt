package configuration

fun <T> kIs(value: T) : org.hamcrest.Matcher<T> = org.hamcrest.core.Is.`is`(value)