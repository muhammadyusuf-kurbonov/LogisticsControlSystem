package uz.qmgroup.di

import AppViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import uz.qmgroup.viewModel.transports.TransportDialogViewModel
import uz.qmgroup.viewModel.transports.TransportsViewModel

object AppKoinComponent : KoinComponent {
    init {
        val localViewModelsModule = module {
            singleOf(::AppViewModel)
        }

        startKoin {
            printLogger()

            modules(driverProviderModule, repositoryModule, viewModelsModule, localViewModelsModule)
        }
    }

    val appViewModel: AppViewModel by inject()
    val transportsViewModel: TransportsViewModel by inject()
    val transportDialogViewModel: TransportDialogViewModel by inject()
}