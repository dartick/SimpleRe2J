package org.xiaoheshan.simplere2j.parser.handler;

import org.xiaoheshan.simplere2j.ast.AstNode;
import org.xiaoheshan.simplere2j.ast.leaf.LiteralNode;
import org.xiaoheshan.simplere2j.scanner.ScanSource;
import org.xiaoheshan.simplere2j.utils.CharUtil;

import java.util.Deque;

/**
 * @author _Chf
 * @date 2017-09-20
 */
public class LiteralCaseHandler implements CaseHandler {

    @Override
    public boolean matched(char ch) {
        return CharUtil.isLiteral(ch);
    }

    @Override
    public char[] matchedCase() {
        return new char[0];
    }

    @Override
    public void handle(ScanSource source, Deque<AstNode> stack, int mode) {

        /*Deque<LiteralNode> nodes = new LinkedList<LiteralNode>();
        while (!source.isEnd() && CharUtil.isLiteral(source.peek())) {
            nodes.push(new LiteralNode(source.poll()));
        }

        for (LiteralNode literalNode : nodes) {
            stack.push(literalNode);
        }*/

        StringBuilder builder = new StringBuilder();

        while (!source.isEnd() && CharUtil.isLiteral(source.peek())) {
            builder.append(source.poll());
        }

        stack.push(new LiteralNode(builder.toString()));

    }

}
