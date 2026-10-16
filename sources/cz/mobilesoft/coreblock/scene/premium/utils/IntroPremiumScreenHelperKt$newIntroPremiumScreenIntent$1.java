package cz.mobilesoft.coreblock.scene.premium.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.utils.IntroPremiumScreenHelperKt", f = "IntroPremiumScreenHelper.kt", l = {63, 66, 67, 68, 76, 107, 142, 140}, m = "newIntroPremiumScreenIntent", v = 1)
final class IntroPremiumScreenHelperKt$newIntroPremiumScreenIntent$1 extends ContinuationImpl {
    int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f113988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f113989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f113990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f113991d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f113992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f113993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f113994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f113995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f113996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f113997k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f113998l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f113999m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f114000n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f114001o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f114002p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f114003q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f114004r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f114005s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f114006t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f114007u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f114008v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f114009w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f114010x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f114011y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    /* synthetic */ Object f114012z;

    IntroPremiumScreenHelperKt$newIntroPremiumScreenIntent$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f114012z = obj;
        this.A |= Integer.MIN_VALUE;
        return IntroPremiumScreenHelperKt.b(null, null, false, false, false, this);
    }
}
