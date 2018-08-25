import java.util.*

class Pokemon(val nombre:String, var hp:Int, val ataque:Int,
              val defensa:Int, val listaAtaques:Array<Ataque>){

fun obtenerAtaque(orden:Int)=if(orden<listaAtaques.size) listaAtaques.get(orden) else listaAtaques.get(0)

}
class Ataque(val nombre:String,val poder:Int){

}
enum class Pokemons(val id:Int){
    BULBASAUR(1),CHARMANDER(2),SQUIRTLE(3),PIKACHU(4)
}

fun main(args:Array<String>){
    println("Elegir un Pokemon!!")
    for((index,c) in Pokemons.values().withIndex()){
        println("${index+1} -> $c")
    }
    val scanner=Scanner(System.`in`)
    val opcion= scanner.nextInt()
    val pokemon: Pokemon=generarPokemon(opcion)
    mostrarDatos(pokemon)

    val random= Random()
    val numeroAzar=1+random.nextInt(4)
    val pokemonSalvaje:Pokemon=generarPokemon(numeroAzar)
    println("Un ${pokemonSalvaje.nombre} ha aparecido!" )
}e
fun mostrarDatos(poke: Pokemon){
    println("Has elegido a ${poke.nombre} \nHP:${poke.hp} \nATAQUE: ${poke.ataque} \nDEFENSA: ${poke.defensa}")
}
fun generarPokemon(opcion:Int):Pokemon=when(opcion){
    Pokemons.BULBASAUR.id->Pokemon("Bulbasaur",120,50,30, arrayOf(Ataque("chorro de agua",15)))
    Pokemons.CHARMANDER.id->Pokemon("charmander",200,70,20,
            arrayOf(Ataque("bola de fuego",30)))
    Pokemons.PIKACHU.id->Pokemon("Pikachu",100,60,50, arrayOf(Ataque("impactrueno",35)))
    Pokemons.SQUIRTLE.id->Pokemon("Squirtle",120,40,60, arrayOf(Ataque("hojas navaja",20)))
    else-> Pokemon("Random",500,1000,200, arrayOf(Ataque("lol",1230)))
}

