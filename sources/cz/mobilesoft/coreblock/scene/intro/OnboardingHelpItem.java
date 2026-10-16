package cz.mobilesoft.coreblock.scene.intro;

import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class OnboardingHelpItem {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f104497f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f104498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f104499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f104500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final OnboardingNavItem f104501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f104502e;

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
    public static final class Other extends OnboardingHelpItem {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Other f104503g = new Other();

        private Other() {
            super("Other", R.drawable.f95496b2, R.string.Ql, OnboardingNavItem.Explanation1Other, 0, null);
        }
    }

    public /* synthetic */ OnboardingHelpItem(String str, int i3, int i4, OnboardingNavItem onboardingNavItem, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i4, onboardingNavItem, i5);
    }

    public final int a() {
        return this.f104499b;
    }

    public final String b() {
        return this.f104498a;
    }

    public final OnboardingNavItem c() {
        return this.f104501d;
    }

    public final int d() {
        return this.f104502e;
    }

    public final int e() {
        return this.f104500c;
    }

    private OnboardingHelpItem(String str, int i3, int i4, OnboardingNavItem onboardingNavItem, int i5) {
        this.f104498a = str;
        this.f104499b = i3;
        this.f104500c = i4;
        this.f104501d = onboardingNavItem;
        this.f104502e = i5;
    }
}
