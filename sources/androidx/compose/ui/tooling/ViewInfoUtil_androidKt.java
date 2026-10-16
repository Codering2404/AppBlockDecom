package androidx.compose.ui.tooling;

import androidx.compose.ui.unit.IntRect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ViewInfoUtil_androidKt {
    public static final List a(List list, Function1 function1) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ViewInfo viewInfo = (ViewInfo) it.next();
            List<ViewInfo> listA = a(viewInfo.c(), function1);
            ArrayList arrayList2 = new ArrayList();
            for (ViewInfo viewInfo2 : listA) {
                CollectionsKt.addAll(arrayList2, viewInfo2.g() == null ? viewInfo2.c() : CollectionsKt.listOf(viewInfo2));
            }
            CollectionsKt.addAll(arrayList, ((Boolean) function1.invoke(viewInfo)).booleanValue() ? CollectionsKt.listOf(new ViewInfo(viewInfo.d(), viewInfo.f(), viewInfo.b(), viewInfo.g(), arrayList2, viewInfo.e())) : CollectionsKt.listOf(new ViewInfo("<root>", -1, IntRect.f29992e.a(), null, arrayList2, null)));
        }
        return arrayList;
    }

    public static final String b(List list, int i3, Function1 function1) {
        String strK = StringsKt.K(".", i3);
        StringBuilder sb = new StringBuilder();
        for (ViewInfo viewInfo : CollectionsKt.sortedWith(a(list, function1), ComparisonsKt.b(new Function1<ViewInfo, Comparable<?>>() { // from class: androidx.compose.ui.tooling.ViewInfoUtil_androidKt$toDebugString$2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Comparable invoke(ViewInfo viewInfo2) {
                return viewInfo2.d();
            }
        }, new Function1<ViewInfo, Comparable<?>>() { // from class: androidx.compose.ui.tooling.ViewInfoUtil_androidKt$toDebugString$3
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Comparable invoke(ViewInfo viewInfo2) {
                return Integer.valueOf(viewInfo2.f());
            }
        }, new Function1<ViewInfo, Comparable<?>>() { // from class: androidx.compose.ui.tooling.ViewInfoUtil_androidKt$toDebugString$4
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Comparable invoke(ViewInfo viewInfo2) {
                return Integer.valueOf(viewInfo2.a().size());
            }
        }))) {
            if (viewInfo.g() != null) {
                sb.append(strK + '|' + viewInfo.d() + ':' + viewInfo.f());
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                sb.append('\n');
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append(strK + "|<root>");
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                sb.append('\n');
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
            String string = StringsKt.t1(b(viewInfo.c(), i3 + 1, function1)).toString();
            if (string.length() > 0) {
                sb.append(string);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                sb.append('\n');
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String c(List list, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        if ((i4 & 2) != 0) {
            function1 = new Function1<ViewInfo, Boolean>() { // from class: androidx.compose.ui.tooling.ViewInfoUtil_androidKt$toDebugString$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(ViewInfo viewInfo) {
                    return Boolean.TRUE;
                }
            };
        }
        return b(list, i3, function1);
    }
}
