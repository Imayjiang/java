package com.jiangbo.util.statemachine;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <p> Date: 2014/8/22 Time: 15:03 </p>
 *
 * @author jiangbo.wjb
 */

public class DFA {

    public static Node rootNode = new Node('R');

    /// <summary>
    /// 根据用户输入的关键词列表查找
    /// </summary>
    public List<String> searchWord(String userStr) {
        List<String> words = new ArrayList<String>();

        List<String> word = new ArrayList<String>();

        char[] chars = userStr.toCharArray();
        Node node = rootNode;
        int i = 0;
        while (i < chars.length) {
            node = findNode(node, chars[i]);
            if (node == null) {
                node = rootNode;
                i = i - word.size();
                word.clear();
            } else if (node.flag == 1) {
                word.add(String.valueOf(chars[i]));
                StringBuilder sb = new StringBuilder();
                for (String str : word) {
                    sb.append(str);
                }
                words.add(sb.toString());
                i = i - word.size() + 1;
                word.clear();
                node = rootNode;
            } else {
                word.add(String.valueOf(chars[i]));
            }
            i++;
        }

        return words;
    }

    /// <summary>
    /// 创建树
    /// </summary>
    public static Node createTree(List<String> strList) {
        for (String str : strList) {
            char[] chars = str.toCharArray();
            if (chars.length > 0) {
                //node.nodes.Add(CreateNode(rootNode, chars, 0));
                createNode(rootNode, chars, 0);
            }
        }
        return rootNode;
    }

    private static Node createNode(Node node, char[] chars, int index) {
        Node n = findNode(node, chars[index]);
        if (n == null) {
            n = new Node(chars[index]);
            node.nodes.add(n);
        }

        if (index == (chars.length - 1)) {
            n.flag = 1;
        }

        index++;
        if (index < chars.length) {
            createNode(n, chars, index);
        }

        return node;

    }

    private static Node findNode(Node node, char c) {
        List<Node> nodes = node.nodes;
        Node result = null;
        for (Node n : nodes) {
            if (n.c == c) {
                result = n;
                break;
            }
        }
        return result;
    }

    public static class Node {
        public char c;
        public int flag; //1：表示终结，0：延续
        public List<Node> nodes = new ArrayList<Node>();

        public Node(char c) {
            this.c = c;
            this.flag = 0;
        }

        public Node(char c, int flag) {
            this.c = c;
            this.flag = flag;
        }
    }

    public static void main(String[] args) {
//        String cacheKeyName ="cacheKeyName";
//        Node node = null;
//        if (node == null)//缓存为空则添加
//        {
//            IList<FiltKeywordsVM> listVM = KeywordManage.GetProFiltKeywordList();
//            List<string> list = new List<string>();
//            foreach(FiltKeywordsVM item in listVM)
//            {
//                list.Add(item.NAME.ToUpper());
//            }
//            node = DFA.CreateTree(list);
//            DateTime time = DateTime.Now.AddHours(ConstClass.FiltKeywordsCacheTime);//Web缓存过期时间
//            System.Web.HttpRuntime.Cache.Add(cacheRsultKeyName, node, null,
//                    time, TimeSpan.Zero, System.Web.Caching.CacheItemPriority.Normal, null);
//        }
//
//        //DFA去过滤脏词
//        DFA dfa = new DFA();
//        List<string> c = dfa.SearchWord(title.ToUpper());

        List<String> list = new ArrayList<String>();
        list.add("search");
        list.add("black");
        list.add("test filter with tree");
        Node node = createTree(list);
        DFA dfa = new DFA();
        List<String> result = dfa.searchWord("test");
        System.out.println(Arrays.toString(result.toArray()));


    }

}


/**
 * dfa
 * 五元组（状态集合、转移函数、字母表、开始状态、接受状态的集合）
 */
