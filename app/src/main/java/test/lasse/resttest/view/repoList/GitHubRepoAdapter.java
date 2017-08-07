package test.lasse.resttest.view.repoList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import test.lasse.resttest.R;
import test.lasse.resttest.model.GitHubRepo;

/**
 * Created by Lasse on 06-Aug-17.
 */

public class GitHubRepoAdapter extends ArrayAdapter<GitHubRepo> {
    public GitHubRepoAdapter(Context context, List<GitHubRepo> repos) {
        super(context, R.layout.repo_list_item, repos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View listItem = inflater.inflate(R.layout.repo_list_item, parent, false);

        GitHubRepo repo = getItem(position);

        TextView name = (TextView) listItem.findViewById(R.id.rli_tv_name);
        name.setText(repo.getName());

        TextView description = (TextView) listItem.findViewById(R.id.rli_tv_description);
        description.setText(repo.getDescription());

        ImageView langImg = (ImageView) listItem.findViewById(R.id.rli_iv_langIcon);
        int imgRes = R.mipmap.missing_icon;

        if(repo.getLanguage() != null) {
            switch (repo.getLanguage().toUpperCase()) {
                case "JAVA":
                    imgRes = R.mipmap.java_icon; break;
                case "ANDROID":
                    imgRes = R.mipmap.android_icon; break;
                case "JAVASCRIPT":
                    imgRes = R.mipmap.javascript_icon; break;
                case "CSS":
                    imgRes = R.mipmap.css_icon; break;
                case "SWIFT":
                    imgRes = R.mipmap.swift_icon; break;
                case "OBJECTIVE-C":
                    imgRes = R.mipmap.objective_c_icon; break;
                case "C":
                    imgRes = R.mipmap.c_icon; break;
                case "C#":
                    imgRes = R.mipmap.c_sharp_icon; break;
                case "C++":
                    imgRes = R.mipmap.c_plus_plus_icon; break;
                case "R":
                    imgRes = R.mipmap.r_icon; break;
                case "GO":
                    imgRes = R.mipmap.go_icon; break;
                case "PYTHON":
                    imgRes = R.mipmap.python_icon; break;
                case "HTML":
                    imgRes = R.mipmap.html_icon; break;
                case "TYPESCRIPT":
                    imgRes = R.mipmap.typescript_icon; break;
                case "DART":
                    imgRes = R.mipmap.dart_icon; break;
                default: break;
            }
        }

        langImg.setImageResource(imgRes);

        return listItem;
    }
}
