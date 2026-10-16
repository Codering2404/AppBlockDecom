package cz.mobilesoft.coreblock.util.widget;

import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.widgets.WidgetDataProvider;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.widget.WidgetDataProviderImpl$startQuickBlock$1", f = "WidgetDataProviderImpl.kt", l = {250}, m = "invokeSuspend", v = 1)
final class WidgetDataProviderImpl$startQuickBlock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f130006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f130007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f130008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f130009d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ WidgetDataProvider.WidgetQuickTimer f130010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ WidgetDataProviderImpl f130011g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f130012a;

        static {
            int[] iArr = new int[WidgetDataProvider.WidgetQuickTimer.values().length];
            try {
                iArr[WidgetDataProvider.WidgetQuickTimer.f134043b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WidgetDataProvider.WidgetQuickTimer.f134044c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WidgetDataProvider.WidgetQuickTimer.f134045d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WidgetDataProvider.WidgetQuickTimer.f134047g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f130012a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetDataProviderImpl$startQuickBlock$1(WidgetDataProvider.WidgetQuickTimer widgetQuickTimer, WidgetDataProviderImpl widgetDataProviderImpl, Continuation continuation) {
        super(2, continuation);
        this.f130010f = widgetQuickTimer;
        this.f130011g = widgetDataProviderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WidgetDataProviderImpl$startQuickBlock$1(this.f130010f, this.f130011g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objC;
        Long l3;
        QuickBlockProfileDTO quickBlockProfileDTO;
        boolean z2;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f130009d;
        if (i3 == 0) {
            ResultKt.b(obj);
            int i4 = WhenMappings.f130012a[this.f130010f.ordinal()];
            Long lE = i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? null : Boxing.e(-1L) : Boxing.e(TimeHelperExt.f128663a.f() + TimeUnit.HOURS.toMillis(24L)) : Boxing.e(TimeHelperExt.f128663a.f() + TimeUnit.HOURS.toMillis(1L)) : Boxing.e(TimeHelperExt.f128663a.f() + TimeUnit.MINUTES.toMillis(25L));
            QuickBlockProfileDTO quickBlockProfileDTOQ = this.f130011g.A().q();
            if (quickBlockProfileDTOQ == null) {
                return Unit.f139807a;
            }
            boolean zN = this.f130011g.B().n();
            WidgetDataProviderImpl widgetDataProviderImpl = this.f130011g;
            this.f130006a = lE;
            this.f130007b = quickBlockProfileDTOQ;
            this.f130008c = zN;
            this.f130009d = 1;
            objC = widgetDataProviderImpl.C(quickBlockProfileDTOQ, this);
            if (objC == objF) {
                return objF;
            }
            l3 = lE;
            quickBlockProfileDTO = quickBlockProfileDTOQ;
            z2 = zN;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z2 = this.f130008c;
            quickBlockProfileDTO = (QuickBlockProfileDTO) this.f130007b;
            Long l4 = (Long) this.f130006a;
            ResultKt.b(obj);
            l3 = l4;
            objC = obj;
        }
        if (((Boolean) objC).booleanValue()) {
            WidgetDataProviderImpl.E(this.f130011g, false, false, false, true, l3, false, 39, null);
        } else if (this.f130011g.x(quickBlockProfileDTO)) {
            Context context = this.f130011g.f129959a;
            WidgetDataProviderImpl widgetDataProviderImpl2 = this.f130011g;
            Intent intentN = WidgetDataProvider.n(widgetDataProviderImpl2, widgetDataProviderImpl2.f129959a, false, true, false, null, 16, null);
            intentN.setFlags(268468224);
            context.startActivity(intentN);
        } else {
            WidgetDataProvider.WidgetQuickTimer widgetQuickTimer = this.f130010f;
            if (widgetQuickTimer == WidgetDataProvider.WidgetQuickTimer.f134047g) {
                WidgetDataProviderImpl.E(this.f130011g, false, true, false, false, null, false, 61, null);
            } else if (widgetQuickTimer == WidgetDataProvider.WidgetQuickTimer.f134048h) {
                WidgetDataProviderImpl.E(this.f130011g, false, false, true, false, null, false, 59, null);
            } else if (z2) {
                WidgetDataProviderImpl.E(this.f130011g, false, false, false, false, null, true, 31, null);
            } else {
                AnswersHelper.f128199a.t8();
                this.f130011g.A().M(l3);
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WidgetDataProviderImpl$startQuickBlock$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
