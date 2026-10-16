package com.superwall.sdk.game;

import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import java.util.Map;
import kotlin.Metadata;

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
public final class GameControllerElementMapper {
    public static final GameControllerElementMapper INSTANCE = new GameControllerElementMapper();

    private GameControllerElementMapper() {
    }

    public final String mapToButtonName(int i3) {
        if (i3 == 96) {
            return "A Button";
        }
        if (i3 == 97) {
            return "B Button";
        }
        if (i3 == 99) {
            return "X Button";
        }
        if (i3 == 100) {
            return "Y Button";
        }
        switch (i3) {
            case 19:
            case 20:
            case 21:
            case 22:
                return "Direction Pad";
            default:
                switch (i3) {
                    case 102:
                        return "L1 Button";
                    case 103:
                        return "R1 Button";
                    case 104:
                        return "L2 Button";
                    case 105:
                        return "R2 Button";
                    case 106:
                        return "Left Thumbstick";
                    case 107:
                        return "Right Thumbstick";
                    case 108:
                        return "Menu Button";
                    case 109:
                        return "Options Button";
                    default:
                        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.gameControllerManager, "Unknown button: " + i3, (Map) null, (Throwable) null, 24, (Object) null);
                        return "Unknown Button";
                }
        }
    }
}
