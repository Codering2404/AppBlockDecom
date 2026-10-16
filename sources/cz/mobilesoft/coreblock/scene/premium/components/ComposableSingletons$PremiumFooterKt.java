package cz.mobilesoft.coreblock.scene.premium.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod;
import cz.mobilesoft.coreblock.util.Success;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;

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
public final class ComposableSingletons$PremiumFooterKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$PremiumFooterKt f112547a = new ComposableSingletons$PremiumFooterKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f112548b = ComposableLambdaKt.c(941685305, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.l
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PremiumFooterKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f112549c = ComposableLambdaKt.c(-673213542, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.m
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PremiumFooterKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(941685305, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.ComposableSingletons$PremiumFooterKt.lambda$941685305.<anonymous> (PremiumFooter.kt:271)");
            }
            PremiumScreenViewState premiumScreenViewState = new PremiumScreenViewState(new PremiumScreenViewState.PremiumScreenTypeViewState() { // from class: cz.mobilesoft.coreblock.scene.premium.components.ComposableSingletons$PremiumFooterKt$lambda$941685305$1$1

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                private final int f112551j = R.string.cC;

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public Integer b() {
                    return Integer.valueOf(this.f112551j);
                }
            }, null, null, null, null, null, null, ExtensionsKt.a(), 0L, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -1377154, 1, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PremiumFooterKt.h();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.components.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$PremiumFooterKt.i((PremiumScreenViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            PremiumFooterKt.h(premiumScreenViewState, true, true, true, true, true, "Footer text", function0, (Function1) objG2, null, false, composer, 115043760, 0, 1536);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(PremiumScreenViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-673213542, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.ComposableSingletons$PremiumFooterKt.lambda$-673213542.<anonymous> (PremiumFooter.kt:299)");
            }
            PremiumOptionDTO premiumOptionDTO = new PremiumOptionDTO(PremiumOptionPeriod.Yearly, false, "premium_yearly", null, "$49.99", "$4.17", null, null, null);
            PersistentList persistentListB = ExtensionsKt.b(premiumOptionDTO);
            PremiumScreenViewState.PremiumScreenTypeViewState premiumScreenTypeViewState = new PremiumScreenViewState.PremiumScreenTypeViewState() { // from class: cz.mobilesoft.coreblock.scene.premium.components.ComposableSingletons$PremiumFooterKt$lambda$-673213542$1$1

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                private final int f112550j = R.string.cC;

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public Integer b() {
                    return Integer.valueOf(this.f112550j);
                }
            };
            long millis = TimeUnit.MINUTES.toMillis(15L);
            Success success = Success.f128020a;
            PremiumScreenViewState premiumScreenViewState = new PremiumScreenViewState(premiumScreenTypeViewState, success, success, null, null, null, null, persistentListB, Long.valueOf(millis), false, false, null, false, false, false, false, true, false, premiumOptionDTO, premiumOptionDTO, null, null, false, false, false, null, null, null, null, null, false, false, false, -1901448, 1, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PremiumFooterKt.k();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.components.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$PremiumFooterKt.l((PremiumScreenViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            PremiumFooterKt.h(premiumScreenViewState, true, false, true, false, false, null, function0, (Function1) objG2, null, true, composer, 113470896, 6, 576);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(PremiumScreenViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
