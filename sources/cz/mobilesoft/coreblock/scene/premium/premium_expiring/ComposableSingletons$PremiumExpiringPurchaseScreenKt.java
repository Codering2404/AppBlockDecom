package cz.mobilesoft.coreblock.scene.premium.premium_expiring;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$PremiumExpiringPurchaseScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$PremiumExpiringPurchaseScreenKt f113530a = new ComposableSingletons$PremiumExpiringPurchaseScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f113531b = ComposableLambdaKt.c(334758408, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.s
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PremiumExpiringPurchaseScreenKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f113532c = ComposableLambdaKt.c(-835523479, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.t
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PremiumExpiringPurchaseScreenKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(334758408, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.ComposableSingletons$PremiumExpiringPurchaseScreenKt.lambda$334758408.<anonymous> (PremiumExpiringPurchaseScreen.kt:167)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$PremiumExpiringPurchaseScreenKt.h((PremiumScreenViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.v
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PremiumExpiringPurchaseScreenKt.i();
                    }
                };
                composer.w(objG2);
            }
            PremiumExpiringPurchaseScreenKt.f("$41.99", "$3.49", function1, (Function0) objG2, "$59.99", composer, 28086, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(PremiumScreenViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-835523479, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.ComposableSingletons$PremiumExpiringPurchaseScreenKt.lambda$-835523479.<anonymous> (PremiumExpiringPurchaseScreen.kt:181)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$PremiumExpiringPurchaseScreenKt.k((PremiumScreenViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PremiumExpiringPurchaseScreenKt.l();
                    }
                };
                composer.w(objG2);
            }
            PremiumExpiringPurchaseScreenKt.f("$59.99", "$4.99", function1, (Function0) objG2, null, composer, 3510, 16);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(PremiumScreenViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l() {
        return Unit.f139807a;
    }
}
