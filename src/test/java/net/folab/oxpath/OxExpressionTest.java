package net.folab.oxpath;

import static org.hamcrest.Matchers.*;
import static net.folab.oxpath.OxExpression.*;
import static net.folab.oxpath.OxPath.any;
import static net.folab.oxpath.OxPath.child;
import static net.folab.oxpath.OxPath.root;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OxExpressionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPack() {

        assertThat(pack("foo"), is("foo"));

        assertThat(pack("/foo"), is("/foo"));

        assertThat(pack("//foo"), is("//foo"));

        assertThat(pack("foo/bar"), is("foo/bar"));

        assertThat(pack("/foo/bar"), is("/foo/bar"));

        assertThat(pack("//foo/bar"), is("//foo/bar"));

        assertThat(pack("foo//bar"), is("foo//bar"));

        assertThat(pack("/foo//bar"), is("/foo//bar"));

        assertThat(pack("//foo//bar"), is("//foo//bar"));

        assertThat(pack("foo/./bar"), is("foo/bar"));

    }

    @Test
    public void testExpr() {

        // Selecting Nodes

        assertThat(child("bookstore").expr(), is("bookstore"));

        assertThat(root().expr(), is("/"));

        assertThat(any().expr(), is("//"));

        assertThat(root().child("bookstore").expr(), is("/bookstore"));

        assertThat(any().child("bookstore").expr(), is("//bookstore"));

        assertThat(child("bookstore").child("book").expr(),
                is("bookstore/book"));

        assertThat(any().child("book").expr(), is("//book"));

        assertThat(child("bookstore").any().child("book").expr(),
                is("bookstore//book"));

        assertThat(any().attr("lang").expr(), is("//@lang"));

        // - - -

        // Predicates

        /*
         * /bookstore/book[1]
         */

        /*
         * /bookstore/book[last()]
         */

        /*
         * /bookstore/book[last()-1]
         */

        /*
         * /bookstore/book[position()<3]
         */

        /*
         * //title[@lang]
         */

        /*
         * //title[@lang='en']
         */

        /*
         * /bookstore/book[price>35.00]
         */

    }

}
