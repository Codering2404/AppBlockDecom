package com.facebook;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface CallbackManager {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ActivityResultParameters {
        public final Intent data;
        public final int requestCode;
        public final int resultCode;

        public ActivityResultParameters(int i3, int i4, Intent intent) {
            this.requestCode = i3;
            this.resultCode = i4;
            this.data = intent;
        }

        public static /* synthetic */ ActivityResultParameters copy$default(ActivityResultParameters activityResultParameters, int i3, int i4, Intent intent, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i3 = activityResultParameters.requestCode;
            }
            if ((i5 & 2) != 0) {
                i4 = activityResultParameters.resultCode;
            }
            if ((i5 & 4) != 0) {
                intent = activityResultParameters.data;
            }
            return activityResultParameters.copy(i3, i4, intent);
        }

        public final int component1() {
            return this.requestCode;
        }

        public final int component2() {
            return this.resultCode;
        }

        public final Intent component3() {
            return this.data;
        }

        public final ActivityResultParameters copy(int i3, int i4, Intent intent) {
            return new ActivityResultParameters(i3, i4, intent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActivityResultParameters)) {
                return false;
            }
            ActivityResultParameters activityResultParameters = (ActivityResultParameters) obj;
            return this.requestCode == activityResultParameters.requestCode && this.resultCode == activityResultParameters.resultCode && Intrinsics.areEqual(this.data, activityResultParameters.data);
        }

        public final Intent getData() {
            return this.data;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.requestCode) * 31) + Integer.hashCode(this.resultCode)) * 31;
            Intent intent = this.data;
            return iHashCode + (intent == null ? 0 : intent.hashCode());
        }

        public String toString() {
            return "ActivityResultParameters(requestCode=" + this.requestCode + ", resultCode=" + this.resultCode + ", data=" + this.data + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory {
        public static final Factory INSTANCE = new Factory();

        @JvmStatic
        public static final CallbackManager create() {
            return new CallbackManagerImpl();
        }
    }

    boolean onActivityResult(int i3, int i4, Intent intent);
}
