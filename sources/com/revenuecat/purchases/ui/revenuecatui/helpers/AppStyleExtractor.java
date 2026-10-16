package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.graphics.drawable.DrawableKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppStyleExtractor {
    public static final int $stable = 0;
    public static final AppStyleExtractor INSTANCE = new AppStyleExtractor();

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor$getProminentColorsFromBitmap$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor$getProminentColorsFromBitmap$2", f = "AppStyleExtractor.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Color>>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ int $count;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Bitmap bitmap, int i3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$count = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$bitmap, this.$count, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.b(obj);
            return AppStyleExtractor.INSTANCE.extractProminentColors$revenuecatui_defaultsBc8Release(this.$bitmap, this.$count);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Color>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    private AppStyleExtractor() {
    }

    private final Triple<Double, Double, Double> colorKeyToTuple(int i3) {
        return new Triple<>(Double.valueOf(normalizedColorComponent(i3, 16)), Double.valueOf(normalizedColorComponent(i3, 8)), Double.valueOf(((double) (i3 & 255)) / 255.0d));
    }

    public static /* synthetic */ Object getProminentColorsFromBitmap$default(AppStyleExtractor appStyleExtractor, Bitmap bitmap, int i3, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 2;
        }
        if ((i4 & 4) != 0) {
            coroutineDispatcher = Dispatchers.a();
        }
        return appStyleExtractor.getProminentColorsFromBitmap(bitmap, i3, coroutineDispatcher, continuation);
    }

    private final double normalizedColorComponent(int i3, int i4) {
        return ((double) ((i3 >> i4) & 255)) / 255.0d;
    }

    private final Integer quantizedColorKeyOrNull(int i3) {
        if (((i3 >> 24) & 255) >= 128) {
            int i4 = (((i3 >> 16) & 255) / 16) * 16;
            int i5 = (((i3 >> 8) & 255) / 16) * 16;
            int i6 = ((i3 & 255) / 16) * 16;
            int i7 = i4 + i5 + i6;
            if (i7 >= 50 && i7 <= 700) {
                return Integer.valueOf(i6 | (i4 << 16) | (i5 << 8));
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: toColor-vNxB06k, reason: not valid java name */
    private final long m1164toColorvNxB06k(Triple<Double, Double, Double> triple) {
        return ColorKt.e((float) ((Number) triple.d()).doubleValue(), (float) ((Number) triple.e()).doubleValue(), (float) ((Number) triple.f()).doubleValue(), 0.0f, null, 24, null);
    }

    /* JADX INFO: renamed from: toTriple-8_81llA, reason: not valid java name */
    private final Triple<Double, Double, Double> m1165toTriple8_81llA(long j3) {
        return new Triple<>(Double.valueOf(Color.y(j3)), Double.valueOf(Color.x(j3)), Double.valueOf(Color.v(j3)));
    }

    public final List<Color> extractProminentColors$revenuecatui_defaultsBc8Release(Bitmap bitmap, int i3) {
        boolean z2;
        Double dValueOf = Double.valueOf(1.0d);
        Double dValueOf2 = Double.valueOf(0.0d);
        if (bitmap == null) {
            return CollectionsKt.emptyList();
        }
        if (i3 <= 0) {
            return CollectionsKt.emptyList();
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight() * width;
        if (height == 0) {
            return CollectionsKt.emptyList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j3 = ColorExtractionConstants.MAX_PIXEL_SAMPLES;
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, height), (int) Math.max(1L, ((((long) height) + j3) - 1) / j3));
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            while (true) {
                Integer numQuantizedColorKeyOrNull = quantizedColorKeyOrNull(bitmap.getPixel(iG % width, iG / width));
                if (numQuantizedColorKeyOrNull != null) {
                    linkedHashMap.put(numQuantizedColorKeyOrNull, Integer.valueOf(((Number) linkedHashMap.getOrDefault(numQuantizedColorKeyOrNull, 0)).intValue() + 1));
                }
                if (iG == iH) {
                    break;
                }
                iG += iL;
            }
        }
        ArrayList arrayList = new ArrayList();
        Triple triple = new Triple(dValueOf2, dValueOf2, dValueOf2);
        Triple triple2 = new Triple(dValueOf, dValueOf, dValueOf);
        Iterator it = CollectionsKt.sortedWith(linkedHashMap.entrySet(), new Comparator() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor$extractProminentColors$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return ComparisonsKt.d((Integer) ((Map.Entry) t3).getValue(), (Integer) ((Map.Entry) t2).getValue());
            }
        }).iterator();
        while (it.hasNext()) {
            Triple<Double, Double, Double> tripleColorKeyToTuple = colorKeyToTuple(((Number) ((Map.Entry) it.next()).getKey()).intValue());
            boolean z3 = ColorComputationHelpersKt.colorDistance(tripleColorKeyToTuple, triple) >= 0.3d && ColorComputationHelpersKt.colorDistance(tripleColorKeyToTuple, triple2) >= 0.3d;
            if (arrayList.isEmpty()) {
                z2 = false;
                if (!z3 && !z2) {
                    arrayList.add(Color.n(m1164toColorvNxB06k(tripleColorKeyToTuple)));
                    if (arrayList.size() >= i3) {
                        break;
                    }
                }
            } else {
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    if (ColorComputationHelpersKt.colorDistance(tripleColorKeyToTuple, INSTANCE.m1165toTriple8_81llA(((Color) obj).B())) < 0.25d) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (!z3) {
                }
            }
        }
        return arrayList;
    }

    public final Bitmap getAppIconBitmap(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Drawable drawable = context.getApplicationInfo().loadIcon(context.getPackageManager());
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            return DrawableKt.b(drawable, 0, 0, Bitmap.Config.ARGB_8888, 3, null);
        } catch (Exception e3) {
            Logger.INSTANCE.e("Failed to load app icon bitmap.", e3);
            return null;
        }
    }

    public final String getAppName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public final Object getProminentColorsFromBitmap(Bitmap bitmap, int i3, CoroutineDispatcher coroutineDispatcher, Continuation<? super List<Color>> continuation) {
        return BuildersKt.g(coroutineDispatcher, new AnonymousClass2(bitmap, i3, null), continuation);
    }
}
