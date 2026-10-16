package com.google.maps.android.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public enum CameraMoveStartedReason {
    UNKNOWN(-2),
    NO_MOVEMENT_YET(-1),
    GESTURE(1),
    API_ANIMATION(2),
    DEVELOPER_ANIMATION(3);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f90589b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f90596a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CameraMoveStartedReason a(int i3) {
            CameraMoveStartedReason cameraMoveStartedReason;
            CameraMoveStartedReason[] cameraMoveStartedReasonArrValues = CameraMoveStartedReason.values();
            int length = cameraMoveStartedReasonArrValues.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    cameraMoveStartedReason = null;
                    break;
                }
                cameraMoveStartedReason = cameraMoveStartedReasonArrValues[i4];
                if (cameraMoveStartedReason.b() == i3) {
                    break;
                }
                i4++;
            }
            return cameraMoveStartedReason == null ? CameraMoveStartedReason.UNKNOWN : cameraMoveStartedReason;
        }

        private Companion() {
        }
    }

    CameraMoveStartedReason(int i3) {
        this.f90596a = i3;
    }

    public final int b() {
        return this.f90596a;
    }
}
