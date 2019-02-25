package potaskun.enot.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment{
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        /*получаем данные из переданого массива*/
        String str = getArguments().getString("phone"); //находим по ключю нужное значение

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder
                .setTitle("Диалоговое окно")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Переданные данные в окно: " + str)
                .setPositiveButton("OK", null)
                .setNegativeButton("Отмена", null);
        return builder.create();
    }
}
