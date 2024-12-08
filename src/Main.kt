import javax.swing.*
import java.awt.*
import kotlin.math.sqrt

//1
//fun main() {
//    val frame = JFrame("Right Triangle Calculator")
//    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
//    frame.setSize(400, 200)
//    frame.layout = FlowLayout()
//
//    val leg1Field = JTextField(10)
//    val leg2Field = JTextField(10)
//    val calculateButton = JButton("Вычислить")
//    val memoArea = JTextArea(10, 20)
//    memoArea.isEditable = false
//
//    calculateButton.addActionListener {
//        try {
//            val leg1 = leg1Field.text.toDouble()
//            val leg2 = leg2Field.text.toDouble()
//            val triangle = RightTriangle(leg1, leg2)
//            memoArea.text = triangle.getTriangleInfo()
//
//            println("Гипотенуза ${triangle.calculateHypotenuse()}")
//        } catch (e: NumberFormatException) {
//            memoArea.text = "Ошибка: Введите корректные числа"
//        } catch (e: IllegalArgumentException){
//            memoArea.text = e.message!!
//        }
//
//    }
//
//    frame.add(JLabel("Первый катет:"))
//    frame.add(leg1Field)
//    frame.add(JLabel("Второй катет:"))
//    frame.add(leg2Field)
//    frame.add(calculateButton)
//    frame.add(JScrollPane(memoArea))
//
//    frame.isVisible = true
//}
//
//data class RightTriangle(val leg1: Double, val leg2: Double) {
//
//    init {
//        require(leg1 >= 0 && leg2 >= 0) { "Катеты должны быть неотрицательными числами" }
//    }
//
//    fun getTriangleInfo(): String {
//        return "Первый катет: $leg1\nВторой катет: $leg2\nПлощадь: ${calculateArea()}"
//    }
//
//    fun calculateArea(): Double {
//        return 0.5 * leg1 * leg2
//    }
//
//
//    fun calculateHypotenuse(): Double{
//        return sqrt(leg1 * leg1 + leg2 * leg2)
//    }
//}

//2
//fun main() {
//    val frame = JFrame("Right Triangle Prism Calculator")
//    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
//    frame.size = Dimension(450, 300)
//    frame.layout = GridLayout(0, 2)
//
//
//    val components = arrayOf(
//        Pair(JLabel("Первый катет:"), JTextField(10)),
//        Pair(JLabel("Второй катет:"), JTextField(10)),
//        Pair(JLabel("Высота:"), JTextField(10)),
//        Pair(JButton("Вычислить"), JTextArea(10, 20).apply { isEditable = false })
//    )
//
//    components.forEach { frame.add(it.first); frame.add(it.second) }
//
//    val (button, memoArea) = components.last() as Pair<JButton, JTextArea>
//
//    button.addActionListener {
//        try {
//            val leg1 = (components[0].second as JTextField).text.toDouble()
//            val leg2 = (components[1].second as JTextField).text.toDouble()
//            val height = (components[2].second as JTextField).text.toDouble()
//
//            val triangle = RightTriangle(leg1, leg2)
//            val prism = RightTrianglePrism(leg1, leg2, height)
//
//            memoArea.text = """
//                Информация о треугольнике:
//                ${triangle.getTriangleInfo()}
//
//                Информация о призме:
//                ${prism.getPrismInfo()}
//            """.trimIndent()
//
//        } catch (e: NumberFormatException) {
//            memoArea.text = "Ошибка: Введите корректные числа"
//        } catch (e: IllegalArgumentException) {
//            memoArea.text = e.message!!
//        }
//    }
//
//
//    frame.isVisible = true
//}
//
//
//
//data class RightTriangle(val leg1: Double, val leg2: Double) {
//    init {
//        require(leg1 >= 0 && leg2 >= 0) { "Катеты должны быть неотрицательными числами" }
//    }
//
//    val area: Double get() = 0.5 * leg1 * leg2
//    val hypotenuse: Double get() = sqrt(leg1 * leg1 + leg2 * leg2)
//
//    fun getTriangleInfo(): String {
//        return """
//            Первый катет: $leg1
//            Второй катет: $leg2
//            Площадь: $area
//            Гипотенуза: $hypotenuse
//        """.trimIndent()
//    }
//}
//
//// Класс-потомок
//class RightTrianglePrism(leg1: Double, leg2: Double, val height: Double) {
//    init {
//        require(height >= 0) { "Высота должна быть неотрицательным числом" }
//    }
//
//    val baseTriangle = RightTriangle(leg1, leg2)
//    val volume: Double get() = baseTriangle.area * height
//
//    fun getPrismInfo(): String {
//        return """
//            Первый катет: ${baseTriangle.leg1}
//            Второй катет: ${baseTriangle.leg2}
//            Высота: $height
//            Объем: $volume
//        """.trimIndent()
//    }
//}

//3

data class RightTriangle(val leg1: Double, val leg2: Double) {
    init {
        require(leg1 >= 0 && leg2 >= 0) { "Катеты должны быть неотрицательными числами" }
    }

    val area: Double get() = 0.5 * leg1 * leg2

    override fun toString(): String {
        return """
            Первый катет: $leg1
            Второй катет: $leg2
            Площадь: $area
        """.trimIndent()
    }
}

class RightTrianglePrism(val base: RightTriangle, val height: Double) {
    init {
        require(height >= 0) { "Высота должна быть неотрицательным числом" }
    }

    val volume: Double get() = base.area * height

    fun getPrismInfo(): String {
        return """
            ${base.toString()} // Вывод информации об основании (треугольнике)
            Высота: $height
            Объём: $volume
        """.trimIndent()
    }
}

fun main() {
    val baseTriangle = RightTriangle(3.0, 4.0)
    val prism = RightTrianglePrism(baseTriangle, 5.0)
    println(prism.getPrismInfo())
}







