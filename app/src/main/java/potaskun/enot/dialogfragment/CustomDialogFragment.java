package potaskun.enot.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment{

    private Datable datable;

    /**
     * получить контекст фрагмента,
     * в качестве которого выступает класс MainActivity.
     * Так как MainActivity реализует интерфейс Datable,
     * то мы можем преобразовать контекст к данному интерфейсу
     * @param context
     */
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        datable = (Datable) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        /*получаем данные из переданого массива*/
        final String str = getArguments().getString("phone"); //находим по ключю нужное значение

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Диалоговое окно");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setMessage("Переданные данные в окно: " + str);
        /**
         * вешаем слущателя на кнопку Ок
         */
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                datable.updateTextView(str);
            }
        });
        builder.setNegativeButton("Отмена", null);
        return builder.create();
    }
}
