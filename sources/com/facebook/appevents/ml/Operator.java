package com.facebook.appevents.ml;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Operator {
    public static final Operator INSTANCE = new Operator();

    private Operator() {
    }

    @JvmStatic
    public static final void addmv(MTensor x2, MTensor b3) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(x2, "x");
            Intrinsics.checkNotNullParameter(b3, "b");
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            int shape3 = x2.getShape(2);
            float[] data = x2.getData();
            float[] data2 = b3.getData();
            for (int i3 = 0; i3 < shape; i3++) {
                for (int i4 = 0; i4 < shape2; i4++) {
                    for (int i5 = 0; i5 < shape3; i5++) {
                        int i6 = (i3 * shape2 * shape3) + (i4 * shape3) + i5;
                        data[i6] = data[i6] + data2[i5];
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @JvmStatic
    public static final MTensor concatenate(MTensor[] tensors) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(tensors, "tensors");
            int shape = tensors[0].getShape(0);
            int shape2 = 0;
            for (MTensor mTensor : tensors) {
                shape2 += mTensor.getShape(1);
            }
            MTensor mTensor2 = new MTensor(new int[]{shape, shape2});
            float[] data = mTensor2.getData();
            for (int i3 = 0; i3 < shape; i3++) {
                int i4 = i3 * shape2;
                int length = tensors.length;
                for (int i5 = 0; i5 < length; i5++) {
                    float[] data2 = tensors[i5].getData();
                    int shape3 = tensors[i5].getShape(1);
                    System.arraycopy(data2, i3 * shape3, data, i4, shape3);
                    i4 += shape3;
                }
            }
            return mTensor2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @JvmStatic
    public static final MTensor conv1D(MTensor x2, MTensor w2) {
        MTensor mTensor;
        MTensor mTensor2 = null;
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x2, "x");
            Intrinsics.checkNotNullParameter(w2, "w");
            int i3 = 0;
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            int shape3 = x2.getShape(2);
            int shape4 = w2.getShape(0);
            int i4 = (shape2 - shape4) + 1;
            int shape5 = w2.getShape(2);
            MTensor mTensor3 = new MTensor(new int[]{shape, i4, shape5});
            float[] data = x2.getData();
            float[] data2 = mTensor3.getData();
            float[] data3 = w2.getData();
            int i5 = 0;
            while (i5 < shape) {
                int i6 = i3;
                while (i6 < shape5) {
                    int i7 = i3;
                    while (i7 < i4) {
                        float f3 = 0.0f;
                        while (i3 < shape4) {
                            mTensor = mTensor2;
                            for (int i8 = 0; i8 < shape3; i8++) {
                                try {
                                    f3 += data[(shape2 * shape3 * i5) + ((i3 + i7) * shape3) + i8] * data3[(((i3 * shape3) + i8) * shape5) + i6];
                                } catch (Throwable th) {
                                    th = th;
                                    CrashShieldHandler.handleThrowable(th, Operator.class);
                                    return mTensor;
                                }
                            }
                            i3++;
                            mTensor2 = mTensor;
                        }
                        MTensor mTensor4 = mTensor2;
                        data2[(i4 * shape5 * i5) + (i7 * shape5) + i6] = f3;
                        i7++;
                        mTensor2 = mTensor4;
                        i3 = 0;
                    }
                    i6++;
                    i3 = 0;
                }
                i5++;
                i3 = 0;
            }
            return mTensor3;
        } catch (Throwable th2) {
            th = th2;
            mTensor = null;
        }
    }

    @JvmStatic
    public static final MTensor dense(MTensor x2, MTensor w2, MTensor b3) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x2, "x");
            Intrinsics.checkNotNullParameter(w2, "w");
            Intrinsics.checkNotNullParameter(b3, "b");
            int shape = x2.getShape(0);
            int shape2 = b3.getShape(0);
            MTensor mTensorMul = mul(x2, w2);
            float[] data = b3.getData();
            float[] data2 = mTensorMul.getData();
            for (int i3 = 0; i3 < shape; i3++) {
                for (int i4 = 0; i4 < shape2; i4++) {
                    int i5 = (i3 * shape2) + i4;
                    data2[i5] = data2[i5] + data[i4];
                }
            }
            return mTensorMul;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @JvmStatic
    public static final MTensor embedding(String[] texts, int i3, MTensor w2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(texts, "texts");
            Intrinsics.checkNotNullParameter(w2, "w");
            int length = texts.length;
            int shape = w2.getShape(1);
            MTensor mTensor = new MTensor(new int[]{length, i3, shape});
            float[] data = mTensor.getData();
            float[] data2 = w2.getData();
            for (int i4 = 0; i4 < length; i4++) {
                int[] iArrVectorize = Utils.INSTANCE.vectorize(texts[i4], i3);
                for (int i5 = 0; i5 < i3; i5++) {
                    System.arraycopy(data2, iArrVectorize[i5] * shape, data, (shape * i3 * i4) + (shape * i5), shape);
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @JvmStatic
    public static final void flatten(MTensor x2, int i3) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(x2, "x");
            if (i3 >= x2.getShapeSize()) {
                return;
            }
            int shapeSize = x2.getShapeSize();
            int shape = 1;
            for (int i4 = i3; i4 < shapeSize; i4++) {
                shape *= x2.getShape(i4);
            }
            int[] iArr = new int[i3 + 1];
            for (int i5 = 0; i5 < i3; i5++) {
                iArr[i5] = x2.getShape(i5);
            }
            iArr[i3] = shape;
            x2.reshape(iArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @JvmStatic
    public static final MTensor maxPool1D(MTensor x2, int i3) {
        MTensor mTensor;
        MTensor mTensor2 = null;
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x2, "x");
            int i4 = 0;
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            int shape3 = x2.getShape(2);
            int i5 = (shape2 - i3) + 1;
            MTensor mTensor3 = new MTensor(new int[]{shape, i5, shape3});
            float[] data = x2.getData();
            float[] data2 = mTensor3.getData();
            int i6 = 0;
            while (i6 < shape) {
                int i7 = i4;
                while (i7 < shape3) {
                    int i8 = i4;
                    while (i8 < i5) {
                        int i9 = i8 * shape3;
                        int i10 = (i6 * i5 * shape3) + i9 + i7;
                        int i11 = (i6 * shape2 * shape3) + i9 + i7;
                        data2[i10] = Float.MIN_VALUE;
                        int i12 = i4;
                        while (i12 < i3) {
                            mTensor = mTensor2;
                            try {
                                data2[i10] = Math.max(data2[i10], data[i11 + (i12 * shape3)]);
                                i12++;
                                mTensor2 = mTensor;
                            } catch (Throwable th) {
                                th = th;
                                CrashShieldHandler.handleThrowable(th, Operator.class);
                                return mTensor;
                            }
                        }
                        i8++;
                        i4 = 0;
                    }
                    i7++;
                    i4 = 0;
                }
                i6++;
                i4 = 0;
            }
            return mTensor3;
        } catch (Throwable th2) {
            th = th2;
            mTensor = mTensor2;
        }
    }

    @JvmStatic
    public static final MTensor mul(MTensor x2, MTensor w2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x2, "x");
            Intrinsics.checkNotNullParameter(w2, "w");
            int shape = x2.getShape(0);
            int shape2 = w2.getShape(0);
            int shape3 = w2.getShape(1);
            MTensor mTensor = new MTensor(new int[]{shape, shape3});
            float[] data = x2.getData();
            float[] data2 = w2.getData();
            float[] data3 = mTensor.getData();
            for (int i3 = 0; i3 < shape; i3++) {
                for (int i4 = 0; i4 < shape3; i4++) {
                    int i5 = (i3 * shape3) + i4;
                    data3[i5] = 0.0f;
                    for (int i6 = 0; i6 < shape2; i6++) {
                        data3[i5] = data3[i5] + (data[(i3 * shape2) + i6] * data2[(i6 * shape3) + i4]);
                    }
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @JvmStatic
    public static final void relu(MTensor x2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(x2, "x");
            float[] data = x2.getData();
            int length = data.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (data[i3] < 0.0f) {
                    data[i3] = 0.0f;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @JvmStatic
    public static final void softmax(MTensor x2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(x2, "x");
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            float[] data = x2.getData();
            for (int i3 = 0; i3 < shape; i3++) {
                int i4 = i3 * shape2;
                int i5 = i4 + shape2;
                float f3 = Float.MIN_VALUE;
                for (int i6 = i4; i6 < i5; i6++) {
                    float f4 = data[i6];
                    if (f4 > f3) {
                        f3 = f4;
                    }
                }
                float f5 = 0.0f;
                for (int i7 = i4; i7 < i5; i7++) {
                    float fExp = (float) Math.exp(data[i7] - f3);
                    data[i7] = fExp;
                    f5 += fExp;
                }
                while (i4 < i5) {
                    data[i4] = data[i4] / f5;
                    i4++;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @JvmStatic
    public static final MTensor transpose2D(MTensor x2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x2, "x");
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            MTensor mTensor = new MTensor(new int[]{shape2, shape});
            float[] data = x2.getData();
            float[] data2 = mTensor.getData();
            for (int i3 = 0; i3 < shape; i3++) {
                for (int i4 = 0; i4 < shape2; i4++) {
                    data2[(i4 * shape) + i3] = data[(i3 * shape2) + i4];
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @JvmStatic
    public static final MTensor transpose3D(MTensor x2) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x2, "x");
            int shape = x2.getShape(0);
            int shape2 = x2.getShape(1);
            int shape3 = x2.getShape(2);
            MTensor mTensor = new MTensor(new int[]{shape3, shape2, shape});
            float[] data = x2.getData();
            float[] data2 = mTensor.getData();
            for (int i3 = 0; i3 < shape; i3++) {
                for (int i4 = 0; i4 < shape2; i4++) {
                    for (int i5 = 0; i5 < shape3; i5++) {
                        data2[(i5 * shape * shape2) + (i4 * shape) + i3] = data[(i3 * shape2 * shape3) + (i4 * shape3) + i5];
                    }
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }
}
