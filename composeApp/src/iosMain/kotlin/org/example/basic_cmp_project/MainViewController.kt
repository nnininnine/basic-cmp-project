package org.example.basic_cmp_project

import androidx.compose.ui.window.ComposeUIViewController
import org.example.basic_cmp_project.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = {
    initKoin()
}) { App() }