package com.facebook.share.internal;

import com.facebook.internal.Validate;
import com.facebook.share.model.GameRequestContent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GameRequestValidation {
    public static void validate(GameRequestContent gameRequestContent) {
        Validate.notNull(gameRequestContent.getMessage(), "message");
        if ((gameRequestContent.getObjectId() != null) ^ (gameRequestContent.getActionType() == GameRequestContent.ActionType.ASKFOR || gameRequestContent.getActionType() == GameRequestContent.ActionType.SEND)) {
            throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
        }
        int i3 = gameRequestContent.getRecipients() != null ? 1 : 0;
        if (gameRequestContent.getSuggestions() != null) {
            i3++;
        }
        if (gameRequestContent.getFilters() != null) {
            i3++;
        }
        if (i3 > 1) {
            throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
        }
    }
}
