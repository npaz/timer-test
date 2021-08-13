package pt.mrpeace.development.timeexampleapp.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pt.mrpeace.development.timeexampleapp.repo.SharedPreferencesWrapper
import pt.mrpeace.development.timeexampleapp.repo.TimeRepository
import pt.mrpeace.development.timeexampleapp.viewmodel.TimeDetailViewModel
import pt.mrpeace.development.timeexampleapp.viewmodel.TimePickerViewModel

val appModule = module {
    single { SharedPreferencesWrapper(androidContext()) }
    single { TimeRepository(get()) }

    viewModel { TimePickerViewModel(get()) }
    viewModel { TimeDetailViewModel(get()) }

}
