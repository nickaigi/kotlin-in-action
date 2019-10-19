package board
import board.Direction.*
import java.lang.IllegalArgumentException

open class SquareBoardImpl(override val width: Int) : SquareBoard {
    private val cells = mutableMapOf<Int, List<Cell>>()

    init {
        val rowCells = mutableListOf<Cell>()
        for (row in 1..width) {
            for (column in 1..width)
                rowCells.add(Cell(row, column))
            cells[row] = rowCells
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? = getCell(i, j)

    override fun getCell(i: Int, j: Int): Cell {
        require(i <= width)

        val rowCells = cells[i]

        return rowCells!![j-1]
    }

    override fun getAllCells(): Collection<Cell> {
        val allCells = mutableListOf<Cell>()
        for ( (_, rowCells) in cells){
            for (cell in rowCells)
                allCells.add(cell)
        }
        return allCells
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        val rowCells = cells[i]
        val result = mutableListOf<Cell>()
        for (j in jRange) {
            if (j < width)
                result.add(rowCells!![j - 1])
        }
        return result
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        val columnCells = mutableListOf<Cell>()
        val result = mutableListOf<Cell>()
        for (i in iRange) {
            val rowCells = cells[i]
            columnCells.add(rowCells!![j -1])
        }

        return result
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? = when (direction){
        UP -> getCellOrNull(i - 1, j)
        DOWN -> getCellOrNull(i + 1, j)
        RIGHT -> getCellOrNull(i, j + 1)
        LEFT -> getCellOrNull(i, j - 1)
    }
}

class GameBoardImpl<T>(override val width: Int) : SquareBoardImpl(width), GameBoard<T> {
    override fun get(cell: Cell): T? {
        TODO("not implemented")
    }

    override fun set(cell: Cell, value: T?) {
        TODO("not implemented")
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        TODO("not implemented")
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        TODO("not implemented")
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        TODO("not implemented")
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        TODO("not implemented")
    }

}

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(2)
fun <T> createGameBoard(width: Int): GameBoard<T> =  GameBoardImpl(2)

