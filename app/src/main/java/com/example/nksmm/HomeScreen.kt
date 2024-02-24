package com.example.nksmm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Paragraph
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

data class Home(
    val imageID: Int,
    val heading: String,
    val content: String
)

@Composable
fun Facts(imageID:Int, heading:String, content:String) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .background(color = Yellow),
            text = heading,
            fontSize = 20.sp
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Black),
            painter = painterResource(id = imageID),
            contentDescription = "nothing"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 10.dp),
            text = content
        )
    }
}

@Composable
fun HomeScreen(
) {
    val contentList = listOf<Home>(
        Home(imageID = R.drawable.image_1, heading = "WELCOME TO THE KNOWLEDGE BOX\n Interesting facts about the Earth~",content = ""),
        Home(imageID = R.drawable.image2, heading = "1. WE'RE THE THIRD ROCK FROM THE SUN",content = "Our home, Earth, is the third planet from the sun and the only world known to support an atmosphere with free oxygen, oceans of liquid water on the surface and life. Earth is one of the four terrestrial planets, according to NASA: Like Mercury, Venus and Mars, it is rocky at the surface.\n" + "\n"),
        Home(imageID = R.drawable.image3, heading = "2. EARTH IS SQUASHED",content = "Earth is not a perfect sphere. According to the National Oceanic and Atmospheric Administration (NOAA), as Earth spins, gravity points toward the center of our planet (assuming for explanation's sake that Earth is a perfect sphere), and a centrifugal force pushes outward. But since this gravity-opposing force acts perpendicular to the axis of Earth, and Earth's axis is tilted, centrifugal force at the equator is not exactly opposed to gravity. "),
        Home(imageID = R.drawable.image4, heading = "3. THE PLANET HAS A WAISTLINE",content = "Gravity pushes extra masses of water and earth into a bulge, or \"spare tire\" around our planet. At the equator, the circumference of the globe is 24,901 miles (40,075 kilometers), according to Space.com. Bonus fact: At the equator, you would weigh less than if standing at one of the poles."),
        Home(imageID = R.drawable.image5, heading = "4. EARTH IS ON THE MOVE",content = "You may feel like you're standing still, but you're constantly  moving — fast. Depending on where you are on the globe, you could be spinning with the planet  at just over 1,000 miles per hour, according to Space.com. \n" +
                "\n" +
                "People on the equator move the fastest, while someone standing on the North or South pole would be perfectly still. (Imagine a basketball spinning on your finger. A random point on the ball's equator has farther to go in a single spin as a point near your finger. Thus, the point on the equator is moving faster.)"),
        Home(imageID = R.drawable.image6, heading = "5. THE PLANET MOVES AROUND THE SUN",content = "The Earth isn't just spinning: It's also moving around the sun at 67,000 miles (107,826 km) per hour, according to the American Physical Society."),
        Home(imageID = R.drawable.image7, heading = "6. EARTH IS BILLIONS OF YEARS OLD",content = "Researchers calculate the age of the Earth by dating both the oldest rocks on the planet and meteorites that have been discovered on Earth (meteorites and Earth formed at the same time, when the solar system was forming). Their findings? Earth is about 4.54 billion years old, according to the National Center for Science Education.\n" +
                "\n"),
        Home(imageID = R.drawable.image8, heading = "7. THE PLANET IS RECYCLED",content = "The ground you're walking on is recycled. Earth's rock cycle transforms igneous rocks to sedimentary rocks to metamorphic rocks and back again.\n" +
                "\n" +"The cycle isn’t a perfect circle, but the basics work like this: Magma from deep in the Earth emerges and hardens into rock (that's the igneous part). Tectonic processes uplift that rock to the surface, where erosion shaves bits off. These tiny fragments get deposited and buried, and the pressure from above compacts them into sedimentary rocks such as sandstone. If sedimentary rocks get buried even deeper, they cook into metamorphic rocks under lots of pressure and heat, according to Dorling Kindersley."+"\n"+"Along the way, of course, sedimentary rocks can be re-eroded or metamorphic rocks re-uplifted. But if metamorphic rocks get caught in a subduction zone where one piece of crust is pushing under another, they may find themselves transformed back into magma."),
        Home(imageID = R.drawable.image9, heading = "8. OUR MOON QUAKES",content = "Earth's moon looks rather dead and inactive. But in fact, moonquakes, or \"earthquakes\" on the moon, keep things just a bit shaken up. Quakes on the moon are less common and less intense than those that shake Earth. The total seismic energy released by the moon is about 80 times less than that released by Earth, according to the Encyclopedia of Physical Science and Technology.\n" +
                "\n" +
                "According to the Journal of Geophysical Research, moonquakes seem to be related to tidal stresses associated with the varying distance between the Earth and moon. Moonquakes also tend to occur at great depths, about midway between the lunar surface and its center.\n" +
                "\n"),
        Home(imageID = R.drawable.image10, heading = "9. CHILE HAD THE LARGEST EARTHQUAKE",content = "As of March 2016, the largest earthquake to shake the United States was a magnitude-9.2 temblor that struck Prince William Sound, Alaska, on Good Friday, March 28, 1964. \n" +
                "\n" +
                "The world's largest earthquake was a magnitude 9.5 in Bio-Bio, Chile on May 22, 1960, according to the U.S. Geological Survey (USGS).\n" +
                "\n"),
        Home(imageID = R.drawable.image11, heading = "10. THE HOTTEST SPOT IS IN LIBYA",content = "The fiery award for Earth’s hottest spot goes to El Azizia, Libya, where temperature records from weather stations reveal it hit 136 degrees Fahrenheit (57.8 degrees Celsius) on Sept. 13, 1922, according to NASA Earth Observatory. There have likely been hotter locations beyond the network of weather stations"),
    )

    LazyColumn(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
    ) {

        itemsIndexed(contentList) { _,item ->
            Facts(item.imageID, item.heading,item.content)
        }
    }
}

//@Composable
//fun BarChartComposable(text: MutableState<String>) {
//    val numberOfBars = 10
//    val width = numberOfBars * 70
//    BarChart(
//        bars = Bars(
//            bars = listOf(
//                Bar(10F, "A", Green),
//                Bar(20F, "B", Black),
//                Bar(30F, "C", Cyan),
//                Bar(15F, "D", Color.Blue),
//                Bar(7F, "E", Red),
//                Bar(10F, "A", Green),
//                Bar(20F, "B", Black),
//                Bar(30F, "C", Cyan),
//                Bar(15F, "D", Color.Blue),
//                Bar(7F, "E", Red)
//            )
//        ),
//        modifier = Modifier
//            .horizontalScroll(rememberScrollState())
//            .width(width.dp)
//            .height(500.dp),
//        animation = fadeInAnimation(3000),
//        xAxisDrawer = BarXAxisDrawer(),
//        yAxisDrawer = BarYAxisWithValueDrawer(),
//        labelDrawer = SimpleBarLabelDrawer(),
//        valueDrawer = SimpleBarValueDrawer(drawLocation = SimpleBarValueDrawer.ValueDrawLocation.Inside),
//        barHorizontalMargin = 5.dp
//    )
//}
//
//@Composable
//fun LineChartComposable() {
//    LineChart(
//        lines = listOf(
//            Line(
//                points = listOf(
//                    Point(value = 3F, label = "A"),
//                    Point(value = 15F, label = "B"),
//                    Point(value = 2F, label = "C"),
//                    Point(value = 13F, label = "D"),
//                    Point(value = 6F, label = "E"),
//                    Point(value = 18F, label = "F"),
//                    Point(value = 3F, label = "G"),
//                    Point(value = 15F, label = "H"),
//                    Point(value = 2F, label = "I"),
//                    Point(value = 13F, label = "J"),
//                    Point(value = 6F, label = "K"),
//                    Point(value = 18F, label = "L")
//                ), lineDrawer = SolidLineDrawer(thickness = 8.dp, color = Green)
//            ),
//
//            Line(
//                points = listOf(
//                    Point(value = 5F, label = "A1"),
//                    Point(value = 8F, label = "B1"),
//                    Point(value = 11F, label = "C1"),
//                    Point(value = 14F, label = "D1"),
//                    Point(value = 3F, label = "E1"),
//                    Point(value = 20F, label = "F1"),
//                    Point(value = 5F, label = "A1"),
//                    Point(value = 8F, label = "B1"),
//                    Point(value = 1F, label = "C1"),
//                    Point(value = 14F, label = "D1"),
//                    Point(value = 17F, label = "E1"),
//                    Point(value = 2F, label = "F1")
//                ),
//                lineDrawer = SolidLineDrawer(thickness = 8.dp, color = Red)
//            )
//        ),
//        modifier = Modifier
//            .horizontalScroll(rememberScrollState())
//            .width(1000.dp)
//            .height(500.dp),
//        animation = fadeInAnimation(3000),
//        pointDrawer = FilledPointDrawer(),
//        xAxisDrawer = LineXAxisDrawer(),
//        yAxisDrawer = LineYAxisWithValueDrawer(),
//        horizontalOffsetPercentage = 1f,
//        lineShader = GradientLineShader(listOf(LightGray, Transparent))
//    )
//}
//
//@Composable
//fun GaugeChartComposable() {
//    GaugeChart(
//        percentValue = 72f, //between 0 and 100
//        modifier = Modifier
//            .padding(horizontal = 16.dp)
//            .fillMaxWidth(),
//        animation = fadeInAnimation(4000),
//        pointerDrawer = NeedleDrawer(needleColor = Black, baseSize = 12.dp),
//        arcDrawer = GaugeArcDrawer(thickness = 32.dp, cap = StrokeCap.Round)
//    )
//}
//
//@Composable
//fun PieChartComposable() {
//    PieChart(
//        pies = Pies(
//            listOf(
//                Slice(35f, Red),
//                Slice(45f, Green),
//                Slice(15f, Yellow),
//                Slice(5f, Cyan)
//            )
//        ),
//        modifier = Modifier.height(340.dp),
//        animation = fadeInAnimation(6000),
//        sliceDrawer = FilledSliceDrawer(thickness = 90f)
//    )
//}