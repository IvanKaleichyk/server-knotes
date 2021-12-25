package com.kaleichyk.extensions

fun getOffset(page: Int, perPage: Int) = ((page - 1) * perPage).toLong()
