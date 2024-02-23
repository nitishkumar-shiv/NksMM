package com.example.nksmm

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.jetchart.bar.Bar
import io.jetchart.bar.BarChart
import io.jetchart.bar.Bars
import io.jetchart.bar.renderer.label.SimpleBarLabelDrawer
import io.jetchart.bar.renderer.label.SimpleBarValueDrawer
import io.jetchart.bar.renderer.xaxis.BarXAxisDrawer
import io.jetchart.bar.renderer.yaxis.BarYAxisWithValueDrawer
import io.jetchart.common.animation.fadeInAnimation
import io.jetchart.gauge.GaugeArcDrawer
import io.jetchart.gauge.GaugeChart
import io.jetchart.gauge.NeedleDrawer
import io.jetchart.line.Line
import io.jetchart.line.LineChart
import io.jetchart.line.Point
import io.jetchart.line.renderer.line.GradientLineShader
import io.jetchart.line.renderer.line.SolidLineDrawer
import io.jetchart.line.renderer.point.FilledPointDrawer
import io.jetchart.line.renderer.xaxis.LineXAxisDrawer
import io.jetchart.line.renderer.yaxis.LineYAxisWithValueDrawer
import io.jetchart.pie.PieChart
import io.jetchart.pie.Pies
import io.jetchart.pie.Slice
import io.jetchart.pie.renderer.FilledSliceDrawer
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
){
    val text = remember {
        mutableStateOf("hi")
    }
    val requestText =  remember {
        mutableStateOf(" ")
    }
    val flag0 = remember {
        mutableStateOf(true)
    }
    val flag1 = remember {
        mutableStateOf(false)
    }
    val flag2 = remember {
        mutableStateOf(false)
    }
    val flag3 = remember {
        mutableStateOf(false)
    }
    val flag4 = remember {
        mutableStateOf(false)
    }
    val flag5 = remember {
        mutableStateOf(false)
    }
    val flag6 = remember {
        mutableStateOf(false)
    }
    val flag7 = remember {
        mutableStateOf(false)
    }
    val flag8 = remember {
        mutableStateOf(false)
    }

    LazyColumn(modifier = Modifier.padding(top = 20.dp)) {
        item {
            Column(modifier = Modifier
                .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (flag0.value) {
                    TextField(label = { Text(text = "Please Enter Your Name~")},
                        value = requestText.value, onValueChange = { newText ->
                        requestText.value = newText
                        flag1.value = true
                    })
                }
                if (flag1.value) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(modifier = Modifier
                        .height(50.dp)
                        .width(300.dp),
                        onClick = {
                            flag0.value=!flag0.value
                            flag1.value=!flag1.value
                            flag2.value=!flag2.value
                        }) {
                        Text(text = "ENTER")
                    }
                }
                if(flag2.value) {
                    Text(
                        text = "Hi ${requestText.value} Welcome to the magics~",
                        fontSize = 30.sp,
                        color = Red
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Please read the below context........" ,
                        fontSize = 30.sp,
                        color = Green
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "At its core, magic is more than mere trickery; it is a manifestation of the human desire to transcend the mundane and glimpse the extraordinary. It speaks to our innate yearning for mystery and awe, offering a glimpse into realms beyond our comprehension. Whether it's the illusion of levitation, the artistry of sleight of hand, or the spectacle of grand illusions, magic holds a mirror to our deepest desires and aspirations." ,
                        fontSize = 30.sp,
                        color = Black
                    )
                    Text(
                        text = "Yet, magic is not confined to the realm of entertainment; it permeates every aspect of our lives, infusing the world with a sense of wonder and possibility. It is present in the beauty of a breathtaking sunset, the serenity of a star-studded night sky, and the intricate patterns of a snowflake. It is in the laughter of children, the bonds of love, and the resilience of the human spirit. In essence, magic is everywhere, waiting to be discovered by those with eyes to see and hearts open to wonder.\n" +
                                "\n" +
                                "But perhaps the greatest magic of all lies within each of us—the power to dream, to create, and to transform our world. It is the magic of imagination, the spark of inspiration, and the courage to pursue our deepest passions. In the end, magic is not just an illusion or a spectacle; it is a celebration of the human spirit, reminding us of the limitless possibilities that await those who dare to believe.\n",
                        fontSize = 30.sp,
                        color = Black
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    Button(modifier = Modifier
                        .height(50.dp)
                        .width(300.dp),
                        onClick = {
                            flag2.value =!flag2.value
                            flag3.value =!flag2.value
                        }) {
                        Text(text = "\"CLICK ME TO SEE THE MAGIC\"")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
                if(flag3.value) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Hi ${requestText.value} Welcome to the magics~",
                        fontSize = 30.sp,
                        color = Red
                    )
                    BarChartComposable(text)
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(modifier = Modifier
                        .height(50.dp)
                        .width(300.dp),
                        onClick = {
                            flag3.value=!flag3.value
                            flag4.value=!flag4.value
                        }) {
                        Text(text = "NEXT MAGIC")
                    }
                }
                if(flag4.value) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Hi ${requestText.value} Welcome to the magics~",
                        fontSize = 30.sp,
                        color = Red
                    )
                    GaugeChartComposable()
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(modifier = Modifier
                        .height(50.dp)
                        .width(300.dp),
                        onClick = {
                            flag4.value=!flag4.value
                            flag5.value=!flag5.value
                        }) {
                        Text(text = "NEXT MAGIC")
                    }
                }
                if(flag5.value) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Hi ${requestText.value} Welcome to the magics~",
                        fontSize = 30.sp,
                        color = Red
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    LineChartComposable()
                    Button(modifier = Modifier
                        .height(50.dp)
                        .width(300.dp),
                        onClick = {
                            flag5.value=!flag5.value
                            flag6.value=!flag6.value
                        }) {
                        Text(text = "NEXT MAGIC")
                    }
                }
                if(flag6.value) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Hi ${requestText.value} Welcome to the magics~",
                        fontSize = 30.sp,
                        color = Red
                    )
                    PieChartComposable()
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(modifier = Modifier
                        .height(50.dp)
                        .width(300.dp),
                        onClick = {
                            flag6.value=!flag6.value
                            flag7.value=!flag7.value
                        }) {
                        Text(text = "NEXT MAGIC")
                    }
                }
                if(flag7.value) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Hi ${requestText.value} We Can Not Show More Magic~",
                        fontSize = 30.sp,
                        color = Red
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "${requestText.value} Please Read why We can not show the magic",
                        fontSize = 30.sp,
                        color = Blue
                    )
                    Text(
                        text = "Moreover, the allure of magic can lead individuals down a path of obsession and addiction, blurring the lines between reality and fantasy. Those who become ensnared by its spell may lose touch with the world around them, becoming isolated and detached from the responsibilities of everyday life. This obsession can lead to reckless behavior and irrational decision-making, putting both themselves and others at risk.",
                        fontSize = 30.sp,
                        color = Black
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "wait for 120 seconds to to see the last magic:")
                        val currentColor = remember { mutableStateOf(Color.Black) }
                        val colorIndex = remember { mutableStateOf(0) }

                        LaunchedEffect(Unit) {
                            val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Magenta, Color.Cyan)
                            while (true) {
                                currentColor.value = colors[colorIndex.value % (colors.size)]
                                colorIndex.value++
                                delay(5000) // Change color every 5 seconds
                            }
                        }
                    Text(
                        text = "Thank you ${requestText.value} we will see you soon....",
                        fontSize = 30.sp,
                        color = currentColor.value
                    )
                }
            }
        }
    }
}

@Composable
fun BarChartComposable(text: MutableState<String>){
    val numberOfBars = 10
    val width = numberOfBars * 70
    BarChart(bars = Bars(bars= listOf(
        Bar(10F,"A", Color.Green),
        Bar(20F,"B", Color.Black),
        Bar(30F,"C", Color.Cyan),
        Bar(15F,"D", Color.Blue),
        Bar(7F,"E", Color.Red),
        Bar(10F,"A", Color.Green),
        Bar(20F,"B", Color.Black),
        Bar(30F,"C", Color.Cyan),
        Bar(15F,"D", Color.Blue),
        Bar(7F,"E", Color.Red)
    )),
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .width(width.dp)
            .height(500.dp),
        animation = fadeInAnimation(3000),
        xAxisDrawer = BarXAxisDrawer(),
        yAxisDrawer = BarYAxisWithValueDrawer(),
        labelDrawer = SimpleBarLabelDrawer(),
        valueDrawer = SimpleBarValueDrawer(drawLocation = SimpleBarValueDrawer.ValueDrawLocation.Inside),
        barHorizontalMargin = 5.dp
    )
}

@Composable
fun LineChartComposable() {
    LineChart(lines = listOf(
        Line(points = listOf(
            Point(value = 3F,label="A"),
            Point(value = 15F,label="B"),
            Point(value = 2F,label="C"),
            Point(value = 13F,label="D"),
            Point(value = 6F,label="E"),
            Point(value = 18F,label="F"),
            Point(value = 3F,label="G"),
            Point(value = 15F,label="H"),
            Point(value = 2F,label="I"),
            Point(value = 13F,label="J"),
            Point(value = 6F,label="K"),
            Point(value = 18F,label="L")
        ), lineDrawer = SolidLineDrawer(thickness = 8.dp, color = Green)),

        Line(points = listOf(
            Point(value = 5F,label="A1"),
            Point(value = 8F,label="B1"),
            Point(value = 11F,label="C1"),
            Point(value = 14F,label="D1"),
            Point(value = 3F,label="E1"),
            Point(value = 20F,label="F1"),
            Point(value = 5F,label="A1"),
            Point(value = 8F,label="B1"),
            Point(value = 1F,label="C1"),
            Point(value = 14F,label="D1"),
            Point(value = 17F,label="E1"),
            Point(value = 2F,label="F1")),
            lineDrawer = SolidLineDrawer(thickness = 8.dp, color = Red ))),
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .width(1000.dp)
            .height(500.dp),
        animation = fadeInAnimation(3000),
        pointDrawer = FilledPointDrawer(),
        xAxisDrawer = LineXAxisDrawer(),
        yAxisDrawer = LineYAxisWithValueDrawer(),
        horizontalOffsetPercentage = 1f,
        lineShader = GradientLineShader(listOf(LightGray, Transparent))
    )
}

@Composable
fun GaugeChartComposable() {
    GaugeChart(
        percentValue = 72f, //between 0 and 100
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        animation = fadeInAnimation(4000),
        pointerDrawer = NeedleDrawer(needleColor = Black, baseSize = 12.dp),
        arcDrawer = GaugeArcDrawer(thickness = 32.dp, cap = StrokeCap.Round)
    )
}

@Composable
fun PieChartComposable() {
    PieChart(pies = Pies(listOf(Slice(35f, Red), Slice(45f, Green), Slice(15f, Yellow), Slice(5f, Cyan))),
        modifier = Modifier.height(340.dp),
        animation = fadeInAnimation(6000),
        sliceDrawer = FilledSliceDrawer(thickness = 90f)
    )
}