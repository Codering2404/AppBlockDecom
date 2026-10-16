package com.superwall.sdk.paywall.presentation.rule_logic.cel;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.MappingKt;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELMember;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class ASTEvaluatorKt {
    public static final CELExpression rewriteASTWith(CELExpression cELExpression, final Function2<? super String, ? super List<? extends PassableValue>, ? extends PassableValue> ctx) {
        Intrinsics.checkNotNullParameter(cELExpression, "<this>");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return cELExpression.mapAll(new Function1() { // from class: com.superwall.sdk.paywall.presentation.rule_logic.cel.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ASTEvaluatorKt.rewriteASTWith$lambda$1(ctx, (CELExpression) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CELExpression rewriteASTWith$lambda$1(Function2 function2, CELExpression it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof CELExpression.FunctionCall) {
            CELExpression.FunctionCall functionCall = (CELExpression.FunctionCall) it;
            CELExpression function = functionCall.getFunction();
            if ((function instanceof CELExpression.Ident) && (functionCall.getReceiver() instanceof CELExpression.Ident) && Intrinsics.areEqual(((CELExpression.Ident) functionCall.getReceiver()).getName(), "platform")) {
                Object name = ((CELExpression.Ident) function).getName();
                List<CELExpression> arguments = functionCall.getArguments();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
                Iterator<T> it2 = arguments.iterator();
                while (it2.hasNext()) {
                    arrayList.add(MappingKt.toPassableValue((CELExpression) it2.next()));
                }
                return MappingKt.toCELExpression((PassableValue) function2.invoke(name, arrayList));
            }
        } else if (it instanceof CELExpression.Member) {
            CELExpression.Member member = (CELExpression.Member) it;
            boolean z2 = (member.getExpr() instanceof CELExpression.Ident) && Intrinsics.areEqual(((CELExpression.Ident) member.getExpr()).getName(), "platform");
            boolean z3 = member.getMember() instanceof CELMember.Attribute;
            if (z2 && z3) {
                CELMember member2 = member.getMember();
                Intrinsics.checkNotNull(member2, "null cannot be cast to non-null type com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELMember.Attribute");
                return MappingKt.toCELExpression((PassableValue) function2.invoke(((CELMember.Attribute) member2).getName(), CollectionsKt.emptyList()));
            }
        }
        return it;
    }
}
