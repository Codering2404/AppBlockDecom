package com.superwall.sdk.identity;

import com.superwall.sdk.misc.primitives.Reducer;
import com.superwall.sdk.misc.primitives.StateActor;
import com.superwall.sdk.storage.AliasId;
import com.superwall.sdk.storage.AppUserId;
import com.superwall.sdk.storage.Seed;
import com.superwall.sdk.storage.Storage;
import com.superwall.sdk.storage.UserAttributes;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class IdentityPersistenceInterceptor {
    public static final IdentityPersistenceInterceptor INSTANCE = new IdentityPersistenceInterceptor();

    private IdentityPersistenceInterceptor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit install$lambda$0(StateActor stateActor, Storage storage, Reducer reducer, Function1 next) {
        Intrinsics.checkNotNullParameter(reducer, "reducer");
        Intrinsics.checkNotNullParameter(next, "next");
        IdentityState identityState = (IdentityState) stateActor.getState().getValue();
        next.invoke(reducer);
        IdentityState identityState2 = (IdentityState) stateActor.getState().getValue();
        if (!Intrinsics.areEqual(identityState2.getAliasId(), identityState.getAliasId())) {
            storage.write(AliasId.INSTANCE, identityState2.getAliasId());
        }
        if (identityState2.getSeed() != identityState.getSeed()) {
            storage.write(Seed.INSTANCE, Integer.valueOf(identityState2.getSeed()));
        }
        if (!Intrinsics.areEqual(identityState2.getUserAttributes(), identityState.getUserAttributes())) {
            storage.write(UserAttributes.INSTANCE, identityState2.getUserAttributes());
        }
        if (!Intrinsics.areEqual(identityState2.getAppUserId(), identityState.getAppUserId())) {
            if (identityState2.getAppUserId() != null) {
                storage.write(AppUserId.INSTANCE, identityState2.getAppUserId());
            } else {
                storage.delete(AppUserId.INSTANCE);
            }
        }
        return Unit.f139807a;
    }

    public final void install(final StateActor<IdentityContext, IdentityState> actor, final Storage storage) {
        Intrinsics.checkNotNullParameter(actor, "actor");
        Intrinsics.checkNotNullParameter(storage, "storage");
        actor.onUpdate(new Function2() { // from class: com.superwall.sdk.identity.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return IdentityPersistenceInterceptor.install$lambda$0(actor, storage, (Reducer) obj, (Function1) obj2);
            }
        });
    }
}
