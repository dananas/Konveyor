package com.github.vacxe.konveyor.generate

data class CustomParameters(val nesting: Int = 100,
                            val customObjectResolver: ObjectResolver = ObjectResolver())