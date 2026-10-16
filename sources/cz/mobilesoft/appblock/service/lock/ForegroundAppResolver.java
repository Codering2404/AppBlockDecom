package cz.mobilesoft.appblock.service.lock;

import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase;
import cz.mobilesoft.coreblock.util.constants.Constants;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class ForegroundAppResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f94769a;

    public ForegroundAppResolver(Function0 foregroundAppsSupplier) {
        Intrinsics.checkNotNullParameter(foregroundAppsSupplier, "foregroundAppsSupplier");
        this.f94769a = foregroundAppsSupplier;
    }

    public final GetForegroundAppsUseCase.AppsDTO a(List activeProfiles, String str) {
        Intrinsics.checkNotNullParameter(activeProfiles, "activeProfiles");
        GetForegroundAppsUseCase.AppsDTO appsDTO = (GetForegroundAppsUseCase.AppsDTO) this.f94769a.invoke();
        if (appsDTO == null) {
            return null;
        }
        if (!appsDTO.c("com.google.android.googlequicksearchbox")) {
            return appsDTO;
        }
        if (Intrinsics.areEqual(appsDTO.i(), "com.google.android.googlequicksearchbox")) {
            Set GOOGLE_GEMINI_CLASS_NAMES = Constants.f128447e;
            Intrinsics.checkNotNullExpressionValue(GOOGLE_GEMINI_CLASS_NAMES, "GOOGLE_GEMINI_CLASS_NAMES");
            if (appsDTO.b(GOOGLE_GEMINI_CLASS_NAMES)) {
                GetForegroundAppsUseCase.AppsDTO appsDTO2 = new GetForegroundAppsUseCase.AppsDTO("com.google.android.apps.bard", appsDTO.k(), appsDTO.m());
                appsDTO2.o(appsDTO.h());
                appsDTO2.p(appsDTO.j());
                return appsDTO2;
            }
        }
        List<ProfileWithConfiguration> list = activeProfiles;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (ProfileWithConfiguration profileWithConfiguration : list) {
                if (!profileWithConfiguration.e(appsDTO.i(), appsDTO.k()).isEmpty() || !profileWithConfiguration.f(appsDTO.i(), appsDTO.k()).isEmpty()) {
                    return appsDTO;
                }
            }
        }
        if (str != null) {
            return new GetForegroundAppsUseCase.AppsDTO(str, null, appsDTO.m());
        }
        return null;
    }
}
