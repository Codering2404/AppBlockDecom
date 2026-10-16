package androidx.glance.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SizeF;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.glance.GlanceId;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AppWidgetUtilsKt {
    public static final long a(DisplayMetrics displayMetrics, AppWidgetManager appWidgetManager, int i3) {
        AppWidgetProviderInfo appWidgetInfo = appWidgetManager.getAppWidgetInfo(i3);
        if (appWidgetInfo == null) {
            return DpSize.f29984b.b();
        }
        int i4 = appWidgetInfo.minWidth;
        int i5 = appWidgetInfo.resizeMode & 1;
        int i6 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iMin = Math.min(i4, i5 != 0 ? appWidgetInfo.minResizeWidth : Integer.MAX_VALUE);
        int i7 = appWidgetInfo.minHeight;
        if ((appWidgetInfo.resizeMode & 2) != 0) {
            i6 = appWidgetInfo.minResizeHeight;
        }
        return DpKt.b(UtilsKt.c(iMin, displayMetrics), UtilsKt.c(Math.min(i7, i6), displayMetrics));
    }

    public static final String b(int i3) {
        return "appWidget-" + i3;
    }

    private static final List c(Bundle bundle, Function0 function0) {
        int i3 = bundle.getInt("appWidgetMinHeight", 0);
        int i4 = bundle.getInt("appWidgetMaxHeight", 0);
        int i5 = bundle.getInt("appWidgetMinWidth", 0);
        int i6 = bundle.getInt("appWidgetMaxWidth", 0);
        return (i3 == 0 || i4 == 0 || i5 == 0 || i6 == 0) ? CollectionsKt.listOf(function0.invoke()) : CollectionsKt.listOf((Object[]) new DpSize[]{DpSize.c(DpKt.b(Dp.g(i5), Dp.g(i4))), DpSize.c(DpKt.b(Dp.g(i6), Dp.g(i3)))});
    }

    public static final List d(Bundle bundle, Function0 function0) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("appWidgetSizes");
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            return c(bundle, function0);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parcelableArrayList, 10));
        int size = parcelableArrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = parcelableArrayList.get(i3);
            i3++;
            SizeF sizeF = (SizeF) obj;
            arrayList.add(DpSize.c(DpKt.b(Dp.g(sizeF.getWidth()), Dp.g(sizeF.getHeight()))));
        }
        return arrayList;
    }

    private static final DpSize e(Bundle bundle) {
        int i3 = bundle.getInt("appWidgetMinHeight", 0);
        int i4 = bundle.getInt("appWidgetMaxWidth", 0);
        if (i3 == 0 || i4 == 0) {
            return null;
        }
        return DpSize.c(DpKt.b(Dp.g(i4), Dp.g(i3)));
    }

    public static final List f(Bundle bundle) {
        return CollectionsKt.listOfNotNull((Object[]) new DpSize[]{e(bundle), g(bundle)});
    }

    private static final DpSize g(Bundle bundle) {
        int i3 = bundle.getInt("appWidgetMaxHeight", 0);
        int i4 = bundle.getInt("appWidgetMinWidth", 0);
        if (i3 == 0 || i4 == 0) {
            return null;
        }
        return DpSize.c(DpKt.b(Dp.g(i4), Dp.g(i3)));
    }

    public static final DpSize h(long j3, Collection collection) {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            long jM = ((DpSize) it.next()).m();
            Pair pairA = i(jM, j3) ? TuplesKt.a(DpSize.c(jM), Float.valueOf(o(j3, jM))) : null;
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                float fFloatValue = ((Number) ((Pair) next).f()).floatValue();
                do {
                    Object next2 = it2.next();
                    float fFloatValue2 = ((Number) ((Pair) next2).f()).floatValue();
                    if (Float.compare(fFloatValue, fFloatValue2) > 0) {
                        next = next2;
                        fFloatValue = fFloatValue2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Pair pair = (Pair) next;
        if (pair != null) {
            return (DpSize) pair.e();
        }
        return null;
    }

    private static final boolean i(long j3, long j4) {
        float f3 = 1;
        return ((float) Math.ceil((double) DpSize.j(j4))) + f3 > DpSize.j(j3) && ((float) Math.ceil((double) DpSize.i(j4))) + f3 > DpSize.i(j3);
    }

    public static final AppWidgetManager j(Context context) {
        Object systemService = context.getSystemService("appwidget");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.appwidget.AppWidgetManager");
        return (AppWidgetManager) systemService;
    }

    public static final long k(AppWidgetProviderInfo appWidgetProviderInfo, DisplayMetrics displayMetrics) {
        int i3 = appWidgetProviderInfo.minWidth;
        int i4 = appWidgetProviderInfo.resizeMode & 1;
        int i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iMin = Math.min(i3, i4 != 0 ? appWidgetProviderInfo.minResizeWidth : Integer.MAX_VALUE);
        int i6 = appWidgetProviderInfo.minHeight;
        if ((appWidgetProviderInfo.resizeMode & 2) != 0) {
            i5 = appWidgetProviderInfo.minResizeHeight;
        }
        return DpKt.b(UtilsKt.c(iMin, displayMetrics), UtilsKt.c(Math.min(i6, i5), displayMetrics));
    }

    public static final void l(Throwable th) {
        Log.e("GlanceAppWidget", "Error in Glance App Widget", th);
    }

    public static final Flow m(GlanceAppWidget glanceAppWidget, Context context, GlanceId glanceId) {
        return FlowKt.j(new AppWidgetUtilsKt$runGlance$1(glanceAppWidget, context, glanceId, null));
    }

    public static final List n(Collection collection) {
        return CollectionsKt.sortedWith(collection, ComparisonsKt.b(new Function1<DpSize, Comparable<?>>() { // from class: androidx.glance.appwidget.AppWidgetUtilsKt$sortedBySize$1
            public final Comparable c(long j3) {
                return Float.valueOf(DpSize.j(j3) * DpSize.i(j3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((DpSize) obj).m());
            }
        }, new Function1<DpSize, Comparable<?>>() { // from class: androidx.glance.appwidget.AppWidgetUtilsKt$sortedBySize$2
            public final Comparable c(long j3) {
                return Float.valueOf(DpSize.j(j3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((DpSize) obj).m());
            }
        }));
    }

    private static final float o(long j3, long j4) {
        float fJ = DpSize.j(j3) - DpSize.j(j4);
        float fI = DpSize.i(j3) - DpSize.i(j4);
        return (fJ * fJ) + (fI * fI);
    }

    public static final String p(AppWidgetId appWidgetId) {
        return b(appWidgetId.a());
    }

    public static final SizeF q(long j3) {
        return new SizeF(DpSize.j(j3), DpSize.i(j3));
    }
}
