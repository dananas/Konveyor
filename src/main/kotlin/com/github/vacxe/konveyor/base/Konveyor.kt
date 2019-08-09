package konveyor.base

import konveyor.generate.ObjectResolver
import konveyor.generate.Generator

class Konveyor {
    companion object {
        internal val GlobalObjectResolver = ObjectResolver()

        fun <T: Any> addCustomType(clazz: Class<T>, lambda: () -> T) =
                GlobalObjectResolver.addCustomType(clazz, lambda)
    }
}
fun <T> randomBuild(clazz: Class<T>): T = randomBuild(clazz, 0)

fun <T> randomBuild(clazz: Class<T>, resolver: ObjectResolver): T = randomBuild(clazz, resolver, 0)

fun <T> randomBuild(clazz: Class<T>, constructorNumber: Int): T = randomBuild(clazz, constructorNumber)

fun <T> randomBuild(clazz: Class<T>, resolver: ObjectResolver, constructorNumber: Int): T =
        Generator(Konveyor.GlobalObjectResolver.merge(resolver)).build(clazz, constructorNumber)

inline fun <reified T : Any> randomBuild(resolver: ObjectResolver = ObjectResolver(), constructorNumber: Int = 0): T =
        randomBuild(T::class.java, resolver, constructorNumber)
