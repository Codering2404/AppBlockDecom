package cz.mobilesoft.coreblock.util.ads;

import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.LazyMutable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

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
public abstract class BaseAdsUtils<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f128127b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f128123f = {Reflection.e(new MutablePropertyReference1Impl(BaseAdsUtils.class, "adLifetimeMS", "getAdLifetimeMS()J", 0))};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f128122d = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f128124g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f128125h = BaseAdsUtils.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyMutable f128126a = new LazyMutable(new Function0() { // from class: cz.mobilesoft.coreblock.util.ads.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Long.valueOf(BaseAdsUtils.c());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f128128c = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.ads.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BaseAdsUtils.i(this.f128189a);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface ConsentFormCallback<T> {
        void l(Object obj, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface ConsentLocationCheckCallback {
        void a();

        void b(boolean z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long c() {
        return PrefManager.f126839a.j0() * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List i(BaseAdsUtils baseAdsUtils) {
        return CollectionsKt.listOfNotNull((Object[]) new String[]{baseAdsUtils.e(), "8DC65EA65E75FD2EBD3DAA58D26D4910", "BB37C718F0E2E04DD28737CB35237C51", "73BEACBEE58469B9EFC2E624C2B166DD", "123E5A4CC14324A8D526DC39FE541EC7", "72C84FE337458F1B7D1AD841016F54ED", "4D5464C74E5A46507ACD5B8E7CEA3F0E", "A172229700AF2EACBD6A2C5C8FF48146", "2727B1C62E36F297765F1D7B433A70F8", "652B87701BE181D7938195D29A5A5EC5", "E48E7EF39EC82155F51F9E757B2B3D3A", "338B8F12262D1F6AF17F2251FBA41DF2", "2153366777D631C6B48D64CA0F1C1901", "EFB2E926AE0BAE2D501D9AECA78DDA28", "6833DA98E0929AC885D5415976A748CB"});
    }

    public final long d() {
        return ((Number) this.f128126a.a(this, f128123f[0])).longValue();
    }

    public String e() {
        return this.f128127b;
    }

    public final List f() {
        return (List) this.f128128c.getValue();
    }

    public final boolean g(PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        return premiumState.f(Product.ADS);
    }

    public final void h(long j3) {
        this.f128126a.b(this, f128123f[0], Long.valueOf(j3));
    }
}
