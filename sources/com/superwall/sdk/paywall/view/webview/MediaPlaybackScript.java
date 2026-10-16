package com.superwall.sdk.paywall.view.webview;

import kotlin.Metadata;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MediaPlaybackScript {
    public static final MediaPlaybackScript INSTANCE = new MediaPlaybackScript();

    private MediaPlaybackScript() {
    }

    public final String build(boolean z2) {
        return StringsKt.n("\n        (() => {\n            const key = '__swMediaPlayback';\n            if (!window[key]) {\n                const state = { allowed: false, suspended: new Set() };\n                state.pause = media => {\n                    if (!media.paused && !media.ended) {\n                        state.suspended.add(media);\n                        media.pause();\n                    }\n                };\n                // Capture also catches autoplay and media inserted after the initial scan.\n                document.addEventListener('play', event => {\n                    if (!state.allowed && event.target instanceof HTMLMediaElement) {\n                        state.pause(event.target);\n                    }\n                }, true);\n                window[key] = state;\n            }\n            const state = window[key];\n            state.allowed = " + z2 + ";\n            if (!state.allowed) {\n                document.querySelectorAll('video, audio').forEach(state.pause);\n            } else {\n                const suspended = Array.from(state.suspended);\n                state.suspended.clear();\n                suspended.forEach(media => {\n                    if (media.isConnected && !media.ended) {\n                        const result = media.play();\n                        if (result) result.catch(() => {});\n                    }\n                });\n            }\n        })();\n        ");
    }
}
