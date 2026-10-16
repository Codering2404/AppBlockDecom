package com.facebook.appevents;

import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.gps.ara.GpsAraTriggersManager;
import com.facebook.appevents.gps.pa.PACustomAudienceClient;
import com.facebook.appevents.gps.topics.GpsTopicsManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.integrity.BannedParamManager;
import com.facebook.appevents.integrity.BlocklistEventsManager;
import com.facebook.appevents.integrity.MACARuleMatchingManager;
import com.facebook.appevents.integrity.ProtectedModeManager;
import com.facebook.appevents.integrity.RedactedEventsManager;
import com.facebook.appevents.integrity.SensitiveParamsManager;
import com.facebook.appevents.integrity.StdParamsEnforcementManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AppEventsManager {
    public static final AppEventsManager INSTANCE = new AppEventsManager();

    private AppEventsManager() {
    }

    @JvmStatic
    public static final void start() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsManager.class)) {
            return;
        }
        try {
            FetchedAppSettingsManager.getAppSettingsAsync(new AnonymousClass1());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsManager.class);
        }
    }

    /* JADX INFO: renamed from: com.facebook.appevents.AppEventsManager$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements FetchedAppSettingsManager.FetchedAppSettingsCallback {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$0(boolean z2) {
            if (z2) {
                MetadataIndexer.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$1(boolean z2) {
            if (z2) {
                RestrictiveDataManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$10(boolean z2) {
            if (z2) {
                RedactedEventsManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$11(boolean z2) {
            if (z2) {
                SensitiveParamsManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$12(boolean z2) {
            if (z2) {
                AppEventsCAPIManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$13(boolean z2) {
            if (z2) {
                GpsAraTriggersManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$14(boolean z2) {
            if (z2) {
                PACustomAudienceClient.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$15(boolean z2) {
            if (z2) {
                GpsTopicsManager.enableTopicsObservation();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$2(boolean z2) {
            if (z2) {
                ModelManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$3(boolean z2) {
            if (z2) {
                EventDeactivationManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$4(boolean z2) {
            if (z2) {
                BannedParamManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$5(boolean z2) {
            if (z2) {
                InAppPurchaseManager.enableAutoLogging();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$6(boolean z2) {
            if (z2) {
                StdParamsEnforcementManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$7(boolean z2) {
            if (z2) {
                ProtectedModeManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$8(boolean z2) {
            if (z2) {
                MACARuleMatchingManager.enable();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSuccess$lambda$9(boolean z2) {
            if (z2) {
                BlocklistEventsManager.enable();
            }
        }

        @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
        public void onSuccess(FetchedAppSettings fetchedAppSettings) {
            FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FeatureManager.Callback() { // from class: com.facebook.appevents.l
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$0(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.Callback() { // from class: com.facebook.appevents.y
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$1(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FeatureManager.Callback() { // from class: com.facebook.appevents.z
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$2(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new FeatureManager.Callback() { // from class: com.facebook.appevents.a0
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$3(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.BannedParamFiltering, new FeatureManager.Callback() { // from class: com.facebook.appevents.m
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$4(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.IapLogging, new FeatureManager.Callback() { // from class: com.facebook.appevents.n
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$5(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.StdParamEnforcement, new FeatureManager.Callback() { // from class: com.facebook.appevents.o
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$6(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.ProtectedMode, new FeatureManager.Callback() { // from class: com.facebook.appevents.p
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$7(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.MACARuleMatching, new FeatureManager.Callback() { // from class: com.facebook.appevents.q
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$8(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.BlocklistEvents, new FeatureManager.Callback() { // from class: com.facebook.appevents.r
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$9(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.FilterRedactedEvents, new FeatureManager.Callback() { // from class: com.facebook.appevents.s
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$10(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.FilterSensitiveParams, new FeatureManager.Callback() { // from class: com.facebook.appevents.t
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$11(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.CloudBridge, new FeatureManager.Callback() { // from class: com.facebook.appevents.u
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$12(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.GPSARATriggers, new FeatureManager.Callback() { // from class: com.facebook.appevents.v
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$13(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.GPSPACAProcessing, new FeatureManager.Callback() { // from class: com.facebook.appevents.w
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$14(z2);
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.GPSTopicsObservation, new FeatureManager.Callback() { // from class: com.facebook.appevents.x
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z2) {
                    AppEventsManager.AnonymousClass1.onSuccess$lambda$15(z2);
                }
            });
        }

        @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
        public void onError() {
        }
    }
}
