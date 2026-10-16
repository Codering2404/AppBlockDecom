package com.facebook.appevents.ml;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

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
public final class MTensor {
    public static final Companion Companion = new Companion(null);
    private int capacity;
    private float[] data;
    private int[] shape;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getCapacity(int[] iArr) {
            if (iArr.length == 0) {
                throw new UnsupportedOperationException("Empty array can't be reduced.");
            }
            int i3 = iArr[0];
            IntIterator it = new IntRange(1, ArraysKt.getLastIndex(iArr)).iterator();
            while (it.hasNext()) {
                i3 *= iArr[it.nextInt()];
            }
            return i3;
        }

        private Companion() {
        }
    }

    public MTensor(int[] shape) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        this.shape = shape;
        int capacity = Companion.getCapacity(shape);
        this.capacity = capacity;
        this.data = new float[capacity];
    }

    public final float[] getData() {
        return this.data;
    }

    public final int getShape(int i3) {
        return this.shape[i3];
    }

    public final int getShapeSize() {
        return this.shape.length;
    }

    public final void reshape(int[] shape) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        this.shape = shape;
        int capacity = Companion.getCapacity(shape);
        float[] fArr = new float[capacity];
        System.arraycopy(this.data, 0, fArr, 0, Math.min(this.capacity, capacity));
        this.data = fArr;
        this.capacity = capacity;
    }
}
