package pl.asia.artshop.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import pl.asia.artshop.product.ProductRepository
import pl.asia.artshop.product.ProductUseCase
import pl.asia.artshop.product.ProductViewModel

val appModule = module {

    single {
        ProductRepository(
            context = androidContext(),

        )
    }

//    single {
//        ProductUseCase(
//            productRepository = get()
//        )
//    }

    singleOf(::ProductUseCase)

    viewModel {
        ProductViewModel(
            productUseCase = get()
        )
    }

    viewModelOf(::ProductViewModel)
}