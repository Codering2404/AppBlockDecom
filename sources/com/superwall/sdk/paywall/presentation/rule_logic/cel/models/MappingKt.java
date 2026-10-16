package com.superwall.sdk.paywall.presentation.rule_logic.cel.models;

import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELAtom;
import com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
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
public final class MappingKt {
    public static final CELExpression toCELExpression(PassableValue passableValue) {
        Intrinsics.checkNotNullParameter(passableValue, "<this>");
        if (passableValue instanceof PassableValue.IntValue) {
            return new CELExpression.Atom(new CELAtom.Int(((PassableValue.IntValue) passableValue).getValue()));
        }
        if (passableValue instanceof PassableValue.UIntValue) {
            return new CELExpression.Atom(new CELAtom.UInt(((PassableValue.UIntValue) passableValue).m1331getValuesVKNKU(), null));
        }
        if (passableValue instanceof PassableValue.FloatValue) {
            return new CELExpression.Atom(new CELAtom.Float(((PassableValue.FloatValue) passableValue).getValue()));
        }
        if (passableValue instanceof PassableValue.StringValue) {
            return new CELExpression.Atom(new CELAtom.String(((PassableValue.StringValue) passableValue).getValue()));
        }
        if (passableValue instanceof PassableValue.BytesValue) {
            return new CELExpression.Atom(new CELAtom.Bytes(((PassableValue.BytesValue) passableValue).getValue()));
        }
        if (passableValue instanceof PassableValue.BoolValue) {
            return new CELExpression.Atom(new CELAtom.Bool(((PassableValue.BoolValue) passableValue).getValue()));
        }
        if (passableValue instanceof PassableValue.TimestampValue) {
            return new CELExpression.Atom(new CELAtom.Int(((PassableValue.TimestampValue) passableValue).getValue()));
        }
        if (Intrinsics.areEqual(passableValue, PassableValue.NullValue.INSTANCE)) {
            return new CELExpression.Atom(CELAtom.Null.INSTANCE);
        }
        if (passableValue instanceof PassableValue.ListValue) {
            List<PassableValue> value = ((PassableValue.ListValue) passableValue).getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(toCELExpression((PassableValue) it.next()));
            }
            return new CELExpression.List(arrayList);
        }
        if (!(passableValue instanceof PassableValue.MapValue)) {
            if (!(passableValue instanceof PassableValue.FunctionValue)) {
                throw new NoWhenBranchMatchedException();
            }
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }
        Map<String, PassableValue> value2 = ((PassableValue.MapValue) passableValue).getValue();
        ArrayList arrayList2 = new ArrayList(value2.size());
        for (Map.Entry<String, PassableValue> entry : value2.entrySet()) {
            arrayList2.add(TuplesKt.a(new CELExpression.Atom(new CELAtom.String(entry.getKey())), toCELExpression(entry.getValue())));
        }
        return new CELExpression.Map(CollectionsKt.toList(arrayList2));
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue toPassableValue(com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression r6) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.rule_logic.cel.models.MappingKt.toPassableValue(com.superwall.sdk.paywall.presentation.rule_logic.cel.models.ast.CELExpression):com.superwall.sdk.paywall.presentation.rule_logic.cel.models.PassableValue");
    }
}
