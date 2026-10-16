package cz.mobilesoft.coreblock.scene.dashboard.shortcuts;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import cz.mobilesoft.coreblock.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DynamicShortcutsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DynamicShortcutsManager f101460a = new DynamicShortcutsManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List f101461b = CollectionsKt.listOf((Object[]) new String[]{"blocking", "strict_mode", "insights"});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List f101462c = CollectionsKt.listOf((Object[]) new String[]{"blocking", "strict_mode", "insights"});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f101463d = 8;

    private DynamicShortcutsManager() {
    }

    private final List a(Context context, String str) {
        return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection<? extends ShortcutInfoCompat>) CollectionsKt.plus((Collection<? extends ShortcutInfoCompat>) CollectionsKt.listOf(f(context)), b(context)), c(context)), (Iterable) e(context, str));
    }

    private final ShortcutInfoCompat b(Context context) {
        ShortcutInfoCompat.Builder builderC = new ShortcutInfoCompat.Builder(context, "do_not_delete_me").i(context.getString(R.string.yc)).c(IconCompat.d(context, R.drawable.v5));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClassName(context.getPackageName(), "cz.mobilesoft.appblock.MainActivity");
        intent.putExtra("SHORTCUT_ACTION", "do_not_delete_me");
        ShortcutInfoCompat shortcutInfoCompatA = builderC.d(intent).h(1).a();
        Intrinsics.checkNotNullExpressionValue(shortcutInfoCompatA, "build(...)");
        return shortcutInfoCompatA;
    }

    private final ShortcutInfoCompat c(Context context) {
        ShortcutInfoCompat.Builder builderC = new ShortcutInfoCompat.Builder(context, "issues").i(context.getString(R.string.f95786e1)).c(IconCompat.d(context, R.drawable.q5));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClassName(context.getPackageName(), "cz.mobilesoft.appblock.MainActivity");
        intent.putExtra("IS_FROM_SHORTCUT", true);
        ShortcutInfoCompat shortcutInfoCompatA = builderC.d(intent).h(2).a();
        Intrinsics.checkNotNullExpressionValue(shortcutInfoCompatA, "build(...)");
        return shortcutInfoCompatA;
    }

    private final ShortcutInfoCompat d(Context context, String str, int i3) {
        Triple triple;
        int iHashCode = str.hashCode();
        if (iHashCode == -664572875) {
            if (str.equals("blocking")) {
                triple = new Triple(Integer.valueOf(R.string.x4), Integer.valueOf(R.drawable.r5), "blocking");
                int iIntValue = ((Number) triple.a()).intValue();
                int iIntValue2 = ((Number) triple.b()).intValue();
                String str2 = (String) triple.c();
                ShortcutInfoCompat.Builder builderC = new ShortcutInfoCompat.Builder(context, str).i(context.getString(iIntValue)).c(IconCompat.d(context, iIntValue2));
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setClassName(context.getPackageName(), "cz.mobilesoft.appblock.MainActivity");
                intent.putExtra("DASHBOARD_TAB", str2);
                ShortcutInfoCompat shortcutInfoCompatA = builderC.d(intent).h(i3).a();
                Intrinsics.checkNotNullExpressionValue(shortcutInfoCompatA, "build(...)");
                return shortcutInfoCompatA;
            }
            throw new IllegalArgumentException("Unknown tab id: " + str);
        }
        if (iHashCode == 545142747) {
            if (str.equals("insights")) {
                triple = new Triple(Integer.valueOf(R.string.zh), Integer.valueOf(R.drawable.t5), "insights");
                int iIntValue3 = ((Number) triple.a()).intValue();
                int iIntValue22 = ((Number) triple.b()).intValue();
                String str22 = (String) triple.c();
                ShortcutInfoCompat.Builder builderC2 = new ShortcutInfoCompat.Builder(context, str).i(context.getString(iIntValue3)).c(IconCompat.d(context, iIntValue22));
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setClassName(context.getPackageName(), "cz.mobilesoft.appblock.MainActivity");
                intent2.putExtra("DASHBOARD_TAB", str22);
                ShortcutInfoCompat shortcutInfoCompatA2 = builderC2.d(intent2).h(i3).a();
                Intrinsics.checkNotNullExpressionValue(shortcutInfoCompatA2, "build(...)");
                return shortcutInfoCompatA2;
            }
            throw new IllegalArgumentException("Unknown tab id: " + str);
        }
        if (iHashCode == 1983998297 && str.equals("strict_mode")) {
            triple = new Triple(Integer.valueOf(R.string.PD), Integer.valueOf(R.drawable.u5), "strict_mode");
            int iIntValue32 = ((Number) triple.a()).intValue();
            int iIntValue222 = ((Number) triple.b()).intValue();
            String str222 = (String) triple.c();
            ShortcutInfoCompat.Builder builderC22 = new ShortcutInfoCompat.Builder(context, str).i(context.getString(iIntValue32)).c(IconCompat.d(context, iIntValue222));
            Intent intent22 = new Intent("android.intent.action.VIEW");
            intent22.setClassName(context.getPackageName(), "cz.mobilesoft.appblock.MainActivity");
            intent22.putExtra("DASHBOARD_TAB", str222);
            ShortcutInfoCompat shortcutInfoCompatA22 = builderC22.d(intent22).h(i3).a();
            Intrinsics.checkNotNullExpressionValue(shortcutInfoCompatA22, "build(...)");
            return shortcutInfoCompatA22;
        }
        throw new IllegalArgumentException("Unknown tab id: " + str);
    }

    private final List e(Context context, String str) {
        List listJ = j(str);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listJ, 10));
        int i3 = 0;
        for (Object obj : listJ) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(f101460a.d(context, (String) obj, i3 + 3));
            i3 = i4;
        }
        return arrayList;
    }

    private final ShortcutInfoCompat f(Context context) {
        ShortcutInfoCompat.Builder builderC = new ShortcutInfoCompat.Builder(context, "unlock_all_apps").i(context.getString(R.string.zA)).c(IconCompat.d(context, R.drawable.s5));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClassName(context.getPackageName(), "cz.mobilesoft.appblock.MainActivity");
        intent.putExtra("SHORTCUT_ACTION", "unlock_all_apps");
        ShortcutInfoCompat shortcutInfoCompatA = builderC.d(intent).h(0).a();
        Intrinsics.checkNotNullExpressionValue(shortcutInfoCompatA, "build(...)");
        return shortcutInfoCompatA;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f A[PHI: r0
      0x001f: PHI (r0v3 java.lang.String) = (r0v2 java.lang.String), (r0v4 java.lang.String) binds: [B:14:0x0027, B:10:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List j(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -664572875(0xffffffffd8636c35, float:-1.00021554E15)
            java.lang.String r2 = "blocking"
            if (r0 == r1) goto L2a
            r1 = 545142747(0x207e37db, float:2.1533118E-19)
            if (r0 == r1) goto L21
            r1 = 1983998297(0x76416959, float:9.807129E32)
            if (r0 == r1) goto L16
            goto L2e
        L16:
            java.lang.String r0 = "strict_mode"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L1f
            goto L2e
        L1f:
            r2 = r0
            goto L2e
        L21:
            java.lang.String r0 = "insights"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L1f
            goto L2e
        L2a:
            boolean r5 = r5.equals(r2)
        L2e:
            java.util.List r5 = cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager.f101462c
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L3b:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L52
            java.lang.Object r1 = r5.next()
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)
            if (r3 != 0) goto L3b
            r0.add(r1)
            goto L3b
        L52:
            java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r2)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.List r5 = kotlin.collections.CollectionsKt.plus(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager.j(java.lang.String):java.util.List");
    }

    public static /* synthetic */ void l(DynamicShortcutsManager dynamicShortcutsManager, Context context, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "blocking";
        }
        dynamicShortcutsManager.k(context, str);
    }

    public final void g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ShortcutManagerCompat.d(context, CollectionsKt.listOf("unlock_all_apps"), null);
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ShortcutInfoCompat shortcutInfoCompatF = f(context);
        ShortcutManagerCompat.e(context, CollectionsKt.listOf(shortcutInfoCompatF));
        ShortcutManagerCompat.a(context, CollectionsKt.listOf(shortcutInfoCompatF));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007a, code lost:
    
        if (r2 == r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009a, code lost:
    
        if (m(r8, r9, r0) != r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(android.content.Context r8, cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager$ensureShortcutsExist$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager$ensureShortcutsExist$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager$ensureShortcutsExist$1) r0
            int r1 = r0.f101469g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f101469g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager$ensureShortcutsExist$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager$ensureShortcutsExist$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f101467d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f101469g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L54
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r8 = r0.f101466c
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r8 = r0.f101465b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r8 = (cz.mobilesoft.coreblock.storage.datastore.CoreDataStore) r8
            java.lang.Object r8 = r0.f101464a
            android.content.Context r8 = (android.content.Context) r8
            kotlin.ResultKt.b(r10)
            goto L9d
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            java.lang.Object r8 = r0.f101466c
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.f101465b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r9 = (cz.mobilesoft.coreblock.storage.datastore.CoreDataStore) r9
            java.lang.Object r2 = r0.f101464a
            android.content.Context r2 = (android.content.Context) r2
            kotlin.ResultKt.b(r10)
            r6 = r10
            r10 = r8
            r8 = r2
            r2 = r6
            goto L7d
        L54:
            kotlin.ResultKt.b(r10)
            java.util.List r10 = androidx.core.content.pm.ShortcutManagerCompat.f(r8)
            java.lang.String r2 = "getDynamicShortcuts(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)
            boolean r2 = r10.isEmpty()
            if (r2 == 0) goto L82
            kotlinx.coroutines.flow.Flow r2 = r9.E2()
            r0.f101464a = r8
            r0.f101465b = r9
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r0.f101466c = r5
            r0.f101469g = r4
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r2 != r1) goto L7d
            goto L9c
        L7d:
            java.lang.String r2 = (java.lang.String) r2
            r7.k(r8, r2)
        L82:
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f101464a = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f101465b = r2
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r0.f101466c = r10
            r0.f101469g = r3
            java.lang.Object r8 = r7.m(r8, r9, r0)
            if (r8 != r1) goto L9d
        L9c:
            return r1
        L9d:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager.i(android.content.Context, cz.mobilesoft.coreblock.storage.datastore.CoreDataStore, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void k(Context context, String lastRoute) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lastRoute, "lastRoute");
        ShortcutManagerCompat.n(context, a(context, lastRoute));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(android.content.Context r5, cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager$refreshUnlockShortcutState$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager$refreshUnlockShortcutState$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager$refreshUnlockShortcutState$1) r0
            int r1 = r0.f101474f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f101474f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager$refreshUnlockShortcutState$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager$refreshUnlockShortcutState$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f101472c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f101474f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f101471b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r5 = (cz.mobilesoft.coreblock.storage.datastore.CoreDataStore) r5
            java.lang.Object r5 = r0.f101470a
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.b(r7)
            goto L51
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.flow.Flow r7 = r6.H2()
            r0.f101470a = r5
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f101471b = r6
            r0.f101474f = r3
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            java.lang.Number r7 = (java.lang.Number) r7
            long r6 = r7.longValue()
            r0 = 0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 != 0) goto L60
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L60:
            long r0 = java.lang.System.currentTimeMillis()
            long r0 = r0 - r6
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.DAYS
            r2 = 30
            long r6 = r6.toMillis(r2)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L74
            r4.h(r5)
        L74:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager.m(android.content.Context, cz.mobilesoft.coreblock.storage.datastore.CoreDataStore, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void n(Context context, String lastRoute) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lastRoute, "lastRoute");
        Iterator it = e(context, lastRoute).iterator();
        while (it.hasNext()) {
            ShortcutManagerCompat.k(context, (ShortcutInfoCompat) it.next());
        }
    }
}
