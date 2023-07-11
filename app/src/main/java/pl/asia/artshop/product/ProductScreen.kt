package pl.asia.artshop.product

/*@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductScreen(productViewModel: ProductViewModel = viewModel()){
    val productUiState by productViewModel.uiState.collectAsState()
//    val imageListSlider = productUiState.imageList
    val pagerState = rememberPagerState(initialPage = 0)
Column(modifier = Modifier
    .verticalScroll(rememberScrollState())) {
    TopSection()
//    HorizontalPager(modifier = Modifier,
//                    pageCount = imageListSlider.size,
//                    state = pagerState) {
//        page -> Card(modifier = Modifier,
//                     shape = RectangleShape) {
//        val newList = imageListSlider[page]
//        Image(painter = painterResource(id = newList),
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.FillBounds,
//                contentDescription = null)
//
//
//    }
//}
//    UnderMainPictureSection(
//        size = imageListSlider.size,
//        index = pagerState.currentPage,
//        onFavouriteClicked = { productViewModel.addToFavourites() }
//    )
//    if (productUiState?.product != null) {
//        MainInfo()
//    }

//    HeadlineDetail(headline = productUiState.headlineDetail, description = productUiState.descriptionDetail)
//    HeadlineDetail(headline = productUiState.headlineDimensions, description = productUiState.descriptionDimensions)
//    HeadlineDetail(headline = productUiState.headlineShipping, description = productUiState.descriptionShipping)

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
            onClick = { },
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
fun UnderMainPictureSection(
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

@Composable
fun MainInfo(modifier: Modifier = Modifier,
             productViewModel: ProductViewModel = viewModel()) {
    val productUiState by productViewModel.uiState.collectAsState()
    Column(modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = productUiState!!.product!!.title,
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
*/