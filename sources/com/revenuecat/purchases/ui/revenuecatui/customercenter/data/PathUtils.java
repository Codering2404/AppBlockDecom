package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonStyle;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PathUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

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
public final class PathUtils {
    public static final int $stable = 0;
    public static final PathUtils INSTANCE = new PathUtils();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SettingsButtonStyle.values().length];
            try {
                iArr[SettingsButtonStyle.FILLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingsButtonStyle.OUTLINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CustomerCenterConfigData.HelpPath.PathType.values().length];
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.CUSTOM_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.CUSTOM_ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.REFUND_REQUEST.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.CHANGE_PLANS.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private PathUtils() {
    }

    private final boolean isGeneralPath(CustomerCenterConfigData.HelpPath helpPath) {
        switch (WhenMappings.$EnumSwitchMapping$1[helpPath.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            case 5:
            case 6:
            case 7:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean isSubscriptionSpecificPath(CustomerCenterConfigData.HelpPath helpPath) {
        switch (WhenMappings.$EnumSwitchMapping$1[helpPath.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return false;
            case 5:
            case 6:
            case 7:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final List<CustomerCenterConfigData.HelpPath> filterGeneralPaths(List<CustomerCenterConfigData.HelpPath> paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        ArrayList arrayList = new ArrayList();
        for (Object obj : paths) {
            if (INSTANCE.isGeneralPath((CustomerCenterConfigData.HelpPath) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<CustomerCenterConfigData.HelpPath> filterSubscriptionSpecificPaths(List<CustomerCenterConfigData.HelpPath> paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        ArrayList arrayList = new ArrayList();
        for (Object obj : paths) {
            if (INSTANCE.isSubscriptionSpecificPath((CustomerCenterConfigData.HelpPath) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final SettingsButtonStyle getButtonStyleForPath(CustomerCenterConfigData.HelpPath path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return isSubscriptionSpecificPath(path) ? SettingsButtonStyle.FILLED : SettingsButtonStyle.OUTLINED;
    }

    public final List<CustomerCenterConfigData.HelpPath> sortPathsByButtonPriority(List<CustomerCenterConfigData.HelpPath> paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        return CollectionsKt.sortedWith(paths, new Comparator() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PathUtils$sortPathsByButtonPriority$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                int i3;
                PathUtils pathUtils = PathUtils.INSTANCE;
                SettingsButtonStyle buttonStyleForPath = pathUtils.getButtonStyleForPath((CustomerCenterConfigData.HelpPath) t2);
                int[] iArr = PathUtils.WhenMappings.$EnumSwitchMapping$0;
                int i4 = iArr[buttonStyleForPath.ordinal()];
                int i5 = 0;
                if (i4 == 1) {
                    i3 = 0;
                } else {
                    if (i4 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i3 = 1;
                }
                Integer numValueOf = Integer.valueOf(i3);
                int i6 = iArr[pathUtils.getButtonStyleForPath((CustomerCenterConfigData.HelpPath) t3).ordinal()];
                if (i6 != 1) {
                    if (i6 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i5 = 1;
                }
                return ComparisonsKt.d(numValueOf, Integer.valueOf(i5));
            }
        });
    }
}
