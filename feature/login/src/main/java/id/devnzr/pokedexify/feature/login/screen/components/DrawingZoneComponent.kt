package id.devnzr.pokedexify.feature.login.screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import id.devnzr.pokedexify.feature.login.utils.drawRandomCurvedLine
import id.devnzr.pokedexify.feature.login.utils.intersectsOtherLine
import java.util.Random

@Composable
fun BackgroundAppBar() {
    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            val path = Path()
            val random = Random()
            val drawnYCoordinates = mutableSetOf<Float>()


            for (i in 0 until 10) {
                var startY = random.nextInt(size.height.toInt()).toFloat()
                var endY = random.nextInt(size.height.toInt()).toFloat()
                var curveX = random.nextInt(size.width.toInt()).toFloat()
                var curveY = random.nextInt(size.width.toInt()).toFloat()

                while (intersectsOtherLine(startY, endY, drawnYCoordinates)) {
                    startY = random.nextInt(size.height.toInt()).toFloat()
                    endY = random.nextInt(size.height.toInt()).toFloat()
                    curveX = random.nextInt(size.width.toInt()).toFloat()
                    curveY = random.nextInt(size.width.toInt()).toFloat()
                }

                drawnYCoordinates.add(startY)
                drawnYCoordinates.add(endY)

                drawRandomCurvedLine(startY, endY, curveX, curveY, this)
            }

            drawPath(
                path = path,
                color = Color.White,
                style = Stroke(
                    width = 2.dp.toPx(),
                )
            )
        }
    )
}