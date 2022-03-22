package com.example.myapplication

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant


class MyFlutterActivity : FlutterActivity() {
    private val CHANNEL = "samples.flutter.dev/battery"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            CHANNEL
        ).setMethodCallHandler { methodCall: MethodCall, result: MethodChannel.Result ->
            if (methodCall.method == "getData") {
                val data = intent.getStringExtra("tag");
                result.success(data) // It returns string "batteryLevel".
            } else {
                result.notImplemented()
            }
        }
    }
}