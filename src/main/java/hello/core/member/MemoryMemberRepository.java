package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
	private static Map<Long, Member> store = new HashMap<>(); //동시성 이슈 때문에 실무에서는 concurrentHashMap를 써야함

	@Override
	public void save(Member member) {
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) {
		return store.get(memberId);
	}
}
