package pl.asia.artshop.product
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import pl.asia.artshop.R
import pl.asia.artshop.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductScreen(productViewModel: ProductViewModel = viewModel()){
    val productUiState by productViewModel.uiState.collectAsState()
    val imageListSlider = productUiState.imageList
    val pagerState = rememberPagerState(initialPage = 0)
Column(modifier = Modifier
    .verticalScroll(rememberScrollState())
    .fillMaxWidth()
    ) {
    TopSection()
    HorizontalPager(pageCount = imageListSlider.size,
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth(),

                       ) {
        page -> Card(modifier = Modifier,
                     shape = RectangleShape) {
        val newList = imageListSlider[page]
        Box(modifier = Modifier.wrapContentSize()
        ){
            Image(painter = painterResource(id = newList),
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
                contentDescription = null)

        }
    }
}
    BottomSection(
        size = imageListSlider.size,
        index = pagerState.currentPage,
        onFavouriteClicked = { productViewModel.addToFavourites() }
    )
    MainInfo()
    HeadlineDetail(headline = productUiState.headlineDetail, description = productUiState.descriptionDetail)
    HeadlineDetail(headline = productUiState.headlineDimensions, description = productUiState.descriptionDimensions)
    HeadlineDetail(headline = productUiState.headlineShipping, description = productUiState.descriptionShipping)

}
}

@Composable
fun Indicator(isSelected:Boolean){
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp
    )

    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) MaterialTheme.colorScheme.secondary
                else MaterialTheme.colorScheme.onBackground.copy(0.5f)
            )
    ){
    }
}

@Composable
fun BoxScope.Indicators(size:Int, index:Int){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.align(Alignment.CenterStart)) {
        repeat(size){
            Indicator(isSelected = it == index)
        }
    }
}

@Composable
fun TopSection(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)){

        //back button
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(Icons.Outlined.KeyboardArrowLeft, contentDescription = null)
        }

        //icon button
        IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(
                painterResource(id = R.drawable.outline_shopping_bag_24),
                contentDescription = null)
        }

        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.Center)
                .offset(120.dp)) {
            Icon(Icons.Outlined.Share,
                contentDescription = null)
        }


    }
}

@Composable
fun BottomSection(
    size: Int,
    index: Int,
    onFavouriteClicked: ()->Unit
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp),
        contentAlignment = Alignment.Center) {

        FloatingActionButton(
            onClick = onFavouriteClicked,
            modifier = Modifier.align(Alignment.CenterEnd),
            shape = RoundedCornerShape(100),
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(Icons.Outlined.Favorite, contentDescription = null)
        }

        //indicators
        Indicators(size = size, index = index)

        }
    }


@Preview
@Composable
fun ImageSliderPreview(){
    ProductScreen()
}
/*
@Composable
fun MainPicture (modifier: Modifier = Modifier, productViewModel: ProductViewModel = viewModel())
{val productUiState by productViewModel.uiState.collectAsState()
    Box(modifier = modifier.fillMaxWidth(),
) {
    Image(
        painter = painterResource(productUiState.imageList.size),
        contentDescription = null,
        modifier = modifier
            .align(Alignment.TopCenter)
    )

    IconButton(onClick = { /*TODO*/ },
        modifier = Modifier.align(Alignment.TopStart)) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .scale(1.4F)
                .padding(20.dp)
            )
        }
    IconButton(onClick = { /*TODO*/ },
        modifier = Modifier.align(Alignment.BottomStart)) {
        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = null,
            modifier = Modifier
                .scale(1.4F)
                .padding(start = 13.dp, bottom = 60.dp)
            )
        }
    IconButton(onClick = { /*TODO*/ },
        modifier = Modifier.align(Alignment.BottomStart)) {
        Icon(
            imageVector = Icons.Outlined.Favorite,
            contentDescription = null,
            modifier = Modifier
                .scale(1.4F)
                .padding(20.dp),
        )
    }
    IconButton(onClick = { /*TODO*/ },
        modifier = Modifier.align(Alignment.TopEnd)) {
        Icon(
            painterResource(id = R.drawable.outline_shopping_bag_24),
            contentDescription = null,
            modifier = Modifier
                .scale(1.4F)
                .padding(20.dp),
        )
    }
    }

}
*/
@Composable
fun MainInfo(modifier: Modifier = Modifier,
             productViewModel: ProductViewModel = viewModel()) {
    val productUiState by productViewModel.uiState.collectAsState()
    Column(modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = productUiState.name,
            style = Typography.bodyLarge,
            modifier = modifier.padding(5.dp))
        Text(text = productUiState.price,
            style = Typography.bodyLarge,
            fontSize = 20.sp)
        Text(text = productUiState.description,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(15.dp),
            style = Typography.titleLarge)

    }
}

@Composable
fun HeadlineDetail (headline: String, description: String) {
    var expanded by remember { mutableStateOf(false) }
    val extraPadding = if (expanded) 15.dp else 0.dp


    Button(
        onClick = { expanded = !expanded },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 50.dp)
            .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = extraPadding),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = headline,
                style = Typography.titleLarge,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.tertiary
            )
            if (expanded) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary
                )
            } else {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),

            horizontalArrangement = Arrangement.Start,
        ) {if (expanded) {
            Text(
                text = description,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}}}


@Composable
fun SimilarItems(modifier: Modifier = Modifier){
        Surface(modifier = modifier,
                shape = MaterialTheme.shapes.small) {
            Column(modifier = Modifier.width(150.dp)) {
                Image(painterResource(id = R.drawable.flower_pot4c), contentDescription = null)
                Text(text = "Name", modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 5.dp))
                Text(text = "Details", modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 10.dp))
                
            }

}

}

@Preview(showBackground = true, backgroundColor = 0xFFE7DACC)
@Composable
fun SimilarItemsPreview(){
    SimilarItems(modifier = Modifier.padding(8.dp))
}

@Preview(showBackground = true, backgroundColor = 0xFFE7DACC)
@Composable
fun MainInfoPreview(){
    MainInfo()
}

@Preview(showSystemUi = true)
@Composable
fun ProductScreenPreview() {
    ProductScreen()
}