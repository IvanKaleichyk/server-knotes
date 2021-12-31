package com.kaleichyk.verifier

interface Validator<T> {

    fun validate(value: T)
}
