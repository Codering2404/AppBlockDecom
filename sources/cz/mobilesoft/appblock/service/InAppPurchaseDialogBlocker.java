package cz.mobilesoft.appblock.service;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

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
public final class InAppPurchaseDialogBlocker {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Companion f94135i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f94136j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f94137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f94138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function0 f94139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f94140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function2 f94141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f94142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Job f94143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f94144h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public InAppPurchaseDialogBlocker(CoroutineScope coroutineScope, Function0 getProfiles, Function0 getForegroundApps, Function0 getWindows, Function2 block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(getProfiles, "getProfiles");
        Intrinsics.checkNotNullParameter(getForegroundApps, "getForegroundApps");
        Intrinsics.checkNotNullParameter(getWindows, "getWindows");
        Intrinsics.checkNotNullParameter(block, "block");
        this.f94137a = coroutineScope;
        this.f94138b = getProfiles;
        this.f94139c = getForegroundApps;
        this.f94140d = getWindows;
        this.f94141e = block;
    }

    private final List e() {
        Iterable iterable = (Iterable) this.f94138b.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            ProfileWithConfiguration profileWithConfiguration = (ProfileWithConfiguration) obj;
            if (profileWithConfiguration.z() && profileWithConfiguration.p().k()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final void f() {
        Job job = this.f94143g;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f94143g = null;
        this.f94144h = null;
    }

    private final boolean h(String str, int i3, CharSequence charSequence, GetForegroundAppsUseCase.AppsDTO appsDTO, List list, boolean z2) {
        String strK;
        if (list.isEmpty() || (strK = k(str, i3, charSequence, appsDTO, (List) this.f94140d.invoke(), this.f94142f, z2)) == null) {
            return false;
        }
        this.f94141e.invoke(strK, list);
        w();
        return true;
    }

    static /* synthetic */ boolean i(InAppPurchaseDialogBlocker inAppPurchaseDialogBlocker, String str, int i3, CharSequence charSequence, GetForegroundAppsUseCase.AppsDTO appsDTO, List list, boolean z2, int i4, Object obj) {
        if ((i4 & 32) != 0) {
            z2 = false;
        }
        return inAppPurchaseDialogBlocker.h(str, i3, charSequence, appsDTO, list, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        List listE = e();
        if (listE.isEmpty()) {
            f();
            return;
        }
        GetForegroundAppsUseCase.AppsDTO appsDTOL = l("com.android.vending", 4194304, listE);
        if (h("com.android.vending", 4194304, Intrinsics.areEqual(appsDTOL != null ? appsDTOL.i() : null, "com.android.vending") ? appsDTOL.h() : this.f94144h, appsDTOL, listE, true)) {
            return;
        }
        f();
    }

    private final String k(String str, int i3, CharSequence charSequence, GetForegroundAppsUseCase.AppsDTO appsDTO, List list, String str2, boolean z2) {
        if (t(str, i3)) {
            return n(str, charSequence, appsDTO, o(list), list, str2, z2);
        }
        return null;
    }

    private final GetForegroundAppsUseCase.AppsDTO l(String str, int i3, List list) {
        if (list.isEmpty() || !t(str, i3)) {
            return null;
        }
        return (GetForegroundAppsUseCase.AppsDTO) this.f94139c.invoke();
    }

    private final String m(CharSequence charSequence, GetForegroundAppsUseCase.AppsDTO appsDTO) {
        if (Intrinsics.areEqual(appsDTO != null ? appsDTO.i() : null, "com.android.vending")) {
            return appsDTO.h();
        }
        if (charSequence == null || !StringsKt.Z0(charSequence, "com.google.android.finsky.", false, 2, null)) {
            return null;
        }
        return charSequence.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x00fc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fd A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String n(java.lang.String r6, java.lang.CharSequence r7, cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase.AppsDTO r8, java.util.List r9, java.util.List r10, java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.InAppPurchaseDialogBlocker.n(java.lang.String, java.lang.CharSequence, cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase$AppsDTO, java.util.List, java.util.List, java.lang.String, boolean):java.lang.String");
    }

    private final List o(List list) {
        return SequencesKt.S(SequencesKt.t(SequencesKt.N(SequencesKt.A(CollectionsKt.asSequence(list), new Function1() { // from class: cz.mobilesoft.appblock.service.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InAppPurchaseDialogBlocker.p((AccessibilityWindowInfo) obj));
            }
        }), new Function1() { // from class: cz.mobilesoft.appblock.service.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InAppPurchaseDialogBlocker.q((AccessibilityWindowInfo) obj);
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(AccessibilityWindowInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getType() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String q(AccessibilityWindowInfo window) {
        CharSequence packageName;
        Intrinsics.checkNotNullParameter(window, "window");
        try {
            AccessibilityNodeInfo root = window.getRoot();
            if (root != null && (packageName = root.getPackageName()) != null) {
                return packageName.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private final boolean r(GetForegroundAppsUseCase.AppsDTO appsDTO, List list) {
        return (appsDTO != null && appsDTO.c("cz.mobilesoft.appblock")) || list.contains("cz.mobilesoft.appblock");
    }

    private final boolean s(String str) {
        return str != null && StringsKt.Y(str, "billing.acquire", true);
    }

    private final boolean t(String str, int i3) {
        return (i3 == 32 || i3 == 2048) ? Intrinsics.areEqual(str, "com.android.vending") || Intrinsics.areEqual(str, "com.android.systemui") : i3 == 4194304;
    }

    private final boolean u(String str) {
        return (Intrinsics.areEqual(str, "com.android.vending") || Intrinsics.areEqual(str, "com.android.systemui") || Intrinsics.areEqual(str, "com.google.android.gms") || Intrinsics.areEqual(str, "cz.mobilesoft.appblock") || Intrinsics.areEqual(str, "com.android.settings") || Intrinsics.areEqual(str, "com.google.android.packageinstaller") || Intrinsics.areEqual(str, "com.google.android.apps.nexuslauncher")) ? false : true;
    }

    private final boolean v(String str) {
        return (!u(str) || Intrinsics.areEqual(str, "com.motorola.launcher3") || Intrinsics.areEqual(str, "com.mi.android.globallauncher") || Intrinsics.areEqual(str, "com.sec.android.app.launcher") || Intrinsics.areEqual(str, "com.miui.home")) ? false : true;
    }

    private final void w() {
        this.f94142f = null;
        f();
    }

    private final void x(String str, int i3, CharSequence charSequence, GetForegroundAppsUseCase.AppsDTO appsDTO, List list) {
        if (list.isEmpty() || !t(str, i3)) {
            return;
        }
        if (Intrinsics.areEqual(str, "com.android.vending") || Intrinsics.areEqual(str, "com.android.systemui")) {
            String strM = m(charSequence, appsDTO);
            if (!s(strM)) {
                if (strM != null) {
                    f();
                }
            } else {
                this.f94144h = strM;
                Job job = this.f94143g;
                if (job == null || !job.isActive()) {
                    this.f94143g = BuildersKt__Builders_commonKt.d(this.f94137a, null, null, new InAppPurchaseDialogBlocker$scheduleGooglePlayBillingConfirmationIfNeeded$1(this, null), 3, null);
                }
            }
        }
    }

    private final void y(String str, int i3, CharSequence charSequence, GetForegroundAppsUseCase.AppsDTO appsDTO) {
        String strM;
        if (u(str)) {
            this.f94142f = str;
            f();
        } else if (Intrinsics.areEqual(str, "com.android.vending") && t(str, i3) && (strM = m(charSequence, appsDTO)) != null && (!s(strM))) {
            this.f94142f = null;
            f();
        }
    }

    public final boolean g(AccessibilityEvent event) {
        String string;
        Intrinsics.checkNotNullParameter(event, "event");
        CharSequence packageName = event.getPackageName();
        if (packageName != null && (string = packageName.toString()) != null) {
            CharSequence className = event.getClassName();
            List listE = e();
            if (listE.isEmpty()) {
                w();
                return false;
            }
            GetForegroundAppsUseCase.AppsDTO appsDTOL = l(string, event.getEventType(), listE);
            if (i(this, string, event.getEventType(), className, appsDTOL, listE, false, 32, null)) {
                return true;
            }
            x(string, event.getEventType(), className, appsDTOL, listE);
            y(string, event.getEventType(), className, appsDTOL);
        }
        return false;
    }
}
