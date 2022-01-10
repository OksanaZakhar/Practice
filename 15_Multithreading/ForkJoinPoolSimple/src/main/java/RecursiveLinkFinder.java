import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.RecursiveTask;


public class RecursiveLinkFinder extends RecursiveTask<List<String>> {

    private List<String> urlsMap;

    public RecursiveLinkFinder(List<String> urlsMap) {
        this.urlsMap = urlsMap;
    }

    @Override
    protected List<String> compute() {
        List<RecursiveLinkFinder> taskList = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        for (String recursiveLink : urlsMap) {
            RecursiveLinkFinder task = new RecursiveLinkFinder(LinkFinder.findPage(recursiveLink));
            task.fork();
            taskList.add(task);
        }
        return urls;
    }
}
