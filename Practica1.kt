import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

fun main() {
    var opcion = 0

    do{
        println("\n--- MENU ---")
        println("1. Sumar tres numeros")
        println("2. Ingresar nombre completo")
        println("3. Calcular Tiempo vivido")
        println("4. Salir")
        println("Seleccione una opcion: ")

        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion){
            1 -> sumarNumeros()
            2 -> ingresarNombre()
            3 -> calcularTiempoVivido()
            4 -> salirPrograma()
            else -> println("Opcion no valida, intente de nuevo.")
        }

    }while (opcion !=4) //Se acaba el while
}

fun sumarNumeros(){
    println("Ingrese tres Numeros: ")

    print("Numero 1: ")
    val num1= readLine()?.toDoubleOrNull() ?: 0.0

    print("Numero 2: ")
    val num2= readLine()?.toDoubleOrNull() ?: 0.0

    print("Numero 3: ")
    val num3= readLine()?.toDoubleOrNull() ?: 0.0

    val suma = num1 + num2 + num3

    println("La suma de los tres numeros es: $suma")
}
fun ingresarNombre(){
    println("Ingrese el nombre completo: ")

    val nombreCompleto = readLine()?.trim() ?: "Nombre no ingresado"

    println("Hola, $nombreCompleto, Bienvenido!!")
}
fun calcularTiempoVivido(){
    println("Ingrese su fecha de nacimiento (YYYY-MM-DD): ")
    val input = readLine()

    try {
        val fechaNacimiento = LocalDate.parse(input)  // Convertir texto a fecha
        val fechaActual = LocalDate.now()  // Fecha de hoy

        if (fechaNacimiento.isAfter(fechaActual)) {
            println("¡Error! La fecha de nacimiento no puede ser en el futuro.")
            return
        }

        val periodo = Period.between(fechaNacimiento, fechaActual)
        val diasVividos = ChronoUnit.DAYS.between(fechaNacimiento, fechaActual)
        val horasVividas = diasVividos * 24
        val minutosVividos = horasVividas * 60
        val segundosVividos = minutosVividos * 60

        println("\nHas vivido hasta hoy:")
        println(" ${periodo.years} años, ${periodo.months} meses y ${periodo.days} días.")
        println(" Un total de $diasVividos días.")
        println(" Aproximadamente $horasVividas horas, $minutosVividos minutos y $segundosVividos segundos.")

    } catch (e: Exception) {  // <- Verifica que esta línea esté presente
        println("¡Formato inválido! Usa el formato YYYY-MM-DD (ejemplo: 2000-05-15).")
    }

}
fun salirPrograma(){
    println("Gracaias por usar el programa. ¡Hasta Luego!")
}